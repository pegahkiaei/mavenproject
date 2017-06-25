/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbu.service.impl;

import com.sbu.controller.model.CourseDetail;
import com.sbu.controller.model.TermDetail;
import com.sbu.controller.model.TermsData;
import com.sbu.dao.SttDAO;
import com.sbu.dao.model.StCot;
import com.sbu.dao.model.Stt;
import com.sbu.service.SttManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


/**
 *
 * @author Pegah
 */
@Service
public class SttManagerImpl implements SttManager{
   public SttManagerImpl() {
    }

    @Autowired
    public SttDAO sttDAO;


    @Override
    public Stt getStudentByUname(String uname,String pass) {
        Stt s = sttDAO.getStt(uname);
        return (s!= null && s.getPassword().equals(pass)?s:null);
    }



    @Override
    public TreeMap<Integer,TermsData> getBriefTableContext(String name, Integer id)
    {
        //here i should get Courses from student and check ,sum and get GPA,
        // and count the not known ones and etcetera etcetera etcetera
        List<StCot> studentCourses = sttDAO.getStudentCoursesByStId(name,id);
        return ((studentCourses.size()==0)?null:fillTermsDatas(studentCourses));
    }
    private TreeMap<Integer,TermsData> fillTermsDatas(List<StCot> studentCourses)
    {
        TreeMap<Integer,TermsData> td = new TreeMap<Integer, TermsData>();//a map with term key and termData value
        int currentTerm = findcurrentTerm(studentCourses);

        for(StCot stct : studentCourses)
        {
            if(!td.containsKey(stct.getTerm()))//the term hasn't created yet!
            {
                //so we create one!
                TermsData entry = new TermsData();
                entry.setTerm(stct.getTerm());
                td.put(stct.getTerm(),entry);
                 addStcotToTd(td,stct);
            }
            else//adding data to a created row!?
            {
                addStcotToTd(td,stct);
            }
        }
        //this for will sett summing and dependant parts
        td.get(td.firstEntry().getKey()).setConsecutiveTakenCredits(td.get(td.firstEntry().getKey()).getTermTakenCredits());
        td.get(td.firstEntry().getKey()).setTotalGPA(td.get(td.firstEntry().getKey()).getGPA());
        td.get(td.firstEntry().getKey()).setTermState(td.get(td.firstEntry().getKey()).getTerm() == currentTerm? "مشغول به تحصیل":"تمام شده");
        td.get(td.firstEntry().getKey()).setProvided(td.get(td.firstEntry().getKey()).getGPA()>12 ?"n":"y");
        td.get(td.firstEntry().getKey()).setTuition(0);
        td.get(td.firstEntry().getKey()).setConsecutivePassedCredits(td.get(td.firstEntry().getKey()).getTermPassedCredits());
        for(int i =1 ; i<td.size() ; i++)
        {
            Integer key = (Integer) td.keySet().toArray()[i];
            Integer previousKey = (Integer) td.keySet().toArray()[i-1];
            //down todo!
            //treeMap is a sorted map
            //واحد گذرانده شده متوالی
            td.get(key).setConsecutivePassedCredits(td.get(previousKey).getConsecutivePassedCredits() + td.get(key).getTermPassedCredits());
            //واحد اخذ شده متوالی
            td.get(key).setConsecutiveTakenCredits(td.get(previousKey).getConsecutiveTakenCredits() +td.get(key).getTermTakenCredits());
            //معدل کل
            td.get(key).setTotalGPA(((td.get(key).getGPA()*(td.get(key).getTermTakenCredits()-td.get(key).getUnknownCredits()))+
                    (td.get(previousKey).getTotalGPA()*(td.get(previousKey).getConsecutiveTakenCredits())))
                    /(td.get(key).getConsecutiveTakenCredits())-td.get(key).getUnknownCredits() );
            //وضعیت تحصیل
            td.get(key).setTermState(td.get(key).getTerm() == currentTerm? "مشغول به تحصیل":"تمام شده");
            td.get(key).setProvided(td.get(key).getGPA()>12 ?"n":"y");



        }

        return td;
    }
    private  TreeMap<Integer,TermsData> addStcotToTd( TreeMap<Integer,TermsData> td ,StCot studentCourse)
    {
        int term = studentCourse.getTerm();
        TermsData termEntry =td.get(term);
        //TODO: [[termstate,consecutiveTakenCourse,]]
        // should be set after StCot loop!as we can find the last term!
        termEntry.setTermTakenCredits( termEntry.getTermTakenCredits()+studentCourse.getCourse().getCredit());//adding this course credits to temcredits

        if(studentCourse.getGrade()!= null)
        {
            //GPA(vahedaye radshode = (GPA*vahedaye akhz shode va nomre dar=(elam shode)(ghabli) + nomre in term*credit)/tedadte kol
            termEntry.setGPA((float)(termEntry.getGPA()*(termEntry.getTermTakenCredits() - termEntry.getUnknownCredits()- studentCourse.getCourse().getCredit() )
                    + studentCourse.getGrade()*studentCourse.getCourse().getCredit())
                    /((termEntry.getTermTakenCredits() - termEntry.getUnknownCredits()- studentCourse.getCourse().getCredit() )+studentCourse.getCourse().getCredit()));
            //vahedaye gozarande shode term=ghabli + alaniye [TODO:the same gozarande shode kol]
            termEntry.setTermPassedCredits(termEntry.getTermPassedCredits()+studentCourse.getCourse().getCredit());
            termEntry.setTotalPassedCredits(termEntry.getTotalPassedCredits()+studentCourse.getCourse().getCredit());
            //vahedye rad shode mmishe +alani ya ghabli age >10 ya kamtar beshe
            termEntry.setFailedCredits(studentCourse.getGrade()>=10?
                    (termEntry.getFailedCredits()):(termEntry.getFailedCredits()+studentCourse.getCourse().getCredit()));
            //vahedaye natamam va hazf shode =0 [notfinishedredits ]

        }
        else
        {
            //vahedaye elam nashode = ghabli+tedad vahedaye in
            termEntry.setUnknownCredits(termEntry.getUnknownCredits() + studentCourse.getCourse().getCredit());

        }
        return td;
    }
    private int findcurrentTerm(List<StCot> studentCourses) {
        int current = 0;
        for (StCot s :studentCourses){
            if(s.getTerm()>current)
                current = s.getTerm();//the last term= the biggest one = current!
        }
        return current;
    }



    @Override
    public List<TermDetail> getTermDetail(Integer term, Integer id) {
        List<StCot> courses = sttDAO.getStudentCoursesByStIdANDterm(term,id);
        return extractCourseBriefDetails(courses);
    }
    private List<TermDetail> extractCourseBriefDetails(List<StCot> courses) {
        List<TermDetail> details = new ArrayList<>();
        for (StCot s : courses)
        {
            TermDetail t = new TermDetail(s.getCourse().getName()
                    ,s.getGrade(),
                    (s.getGrade()>= 10 ?"قبول:)":"رد:("),
                    s.getCourse().getId());
            details.add(t);
        }
        return details;
    }
    @Override
    public Boolean updateUserPass(int id, String usernname, String password)  {
        Stt stt = sttDAO.getStt(id); // who is this?
        Stt possibleDup = sttDAO.getStt(usernname);//maybe this username is taken
        Stt newDep = null;
        if (possibleDup == null || (possibleDup != null && possibleDup.getId() == stt.getId())) {//username is not taken
            System.err.println("%%%%%%%%%%%%%%%%%%%%% going to update it!!");
            stt.setUname(usernname);
            System.err.println(usernname);
            stt.setPassword(password);
            sttDAO.updateStt(stt,usernname,password);
            newDep=sttDAO.getStt(id);
            System.err.println("newDep data here            : " + newDep.getId() + "// " + newDep.getUname());
        }

        Boolean isUpdated = (null != newDep && newDep.getId() == stt.getId());
        return isUpdated;
    }
    @Override
    public Stt getSttByDeptId(int id) {
        Stt d = sttDAO.getStt(id);
        return (d!=null? d:null);
    }

    @Override
    public Stt getSttByManagerId(String username, String password) {
        Stt d=sttDAO.getStt(username,password);
        return (d!=null? d:null);

    }


    @Override
    public CourseDetail getCourseDetail(Integer cid, Integer id ,Integer term) {
        List<StCot> courses = sttDAO.getStudentCoursesByStIdANDterm(term, id);
        return extractCourseDetails(courses,cid,findcurrentTerm(courses));
    }

    private CourseDetail extractCourseDetails(List<StCot> courses,Integer cid , int currentTerm) {
        List<CourseDetail> details = new ArrayList<>();
        for (StCot s : courses)
        {
            if(s.getCourse().getId().equals(cid))
            {
                CourseDetail c = new CourseDetail(cid,
                        s.getCourse().getName()
                        , s.getCourse().getCredit()
                        , s.getGrade()
                        , (s.getGrade() > 10 ? "قبول" : "رد")
                        , (s.getCourse().getType()),
                        (s.getTerm() == currentTerm));
                details.add(c);
            }

        }
        return details.get(0);


    }


}
