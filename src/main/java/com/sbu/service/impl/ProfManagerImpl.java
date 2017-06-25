package com.sbu.service.impl;

import com.sbu.controller.model.Courses;
import com.sbu.controller.model.MyStudent;
import com.sbu.dao.ProfDAO;
import com.sbu.dao.model.*;
import com.sbu.service.ProfManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProfManagerImpl implements ProfManager {

    public ProfManagerImpl() {
    }

    @Autowired
    public ProfDAO profDAO;

    @Override
    public List<Integer> getTermIDByProf(Prof p) {
        List<Integer> termIds =profDAO.getTermCot(p);
        return termIds;
    }
    @Override
    public List<Cot>getCotBytermId(int tid){
        List<Cot>CoName = profDAO.getCot(tid);
        return CoName;
    }
    @Override
    public   List<Stt> getStudentBycourse(String course){
        List<Stt>stnames = profDAO.getStudent(course);
        return stnames;

    }

    @Override
    public Boolean updateUserPass(int id, String usernname, String password)  {
        Prof P = profDAO.getProfByDeptId(id); // who is this?
        Prof possibleDup = profDAO.getProfByDeptId(usernname);//maybe this username is taken
        Prof newDep = null;
        if (possibleDup == null || (possibleDup != null && possibleDup.getId() == P.getId())) {//username is not taken
            System.err.println("%%%%%%%%%%%%%%%%%%%%% going to update it!!");
            P.setUname(usernname);
            System.err.println(usernname);
            P.setPass(password);
            profDAO.updateDept(P,usernname,password);
            newDep=profDAO.getProfByDeptId(id);
            System.err.println("newDep data here            : " + newDep.getId() + "// " + newDep.getUname());
        }

        Boolean isUpdated = (null != newDep && newDep.getId() == P.getId());
        return isUpdated;
    }
    @Override
    public Prof getProfByDeptId(int id) {
        Prof d = profDAO.getProfByDeptId(id);
        return (d!=null? d:null);
    }

    @Override
    public Prof getProfByManagerId(String username, String password) {
        Prof d=profDAO.getProfByDeptId(username,password);
        return (d!=null? d:null);

    }

    @Override
    public Prof getUserByUname(String uname, String pass) {
        Prof p = profDAO.getProfByDeptId(uname);
        //return (p.getPassword().equals(pass)?p:null);
        return (p!= null && p.getPass().equals(pass)? p : null);
    }


    @Override
    public List<Courses> getCoursesByProfId(Integer year, Integer term, Integer pid) {
        Prof p =  profDAO.getProf(pid);
        System.out.println(p.getName());
        List<Courses> list = makeCourseNameList(p.getCourses(),year,term);
        return list;


    }

    @Override
    public List<MyStudent> getstudentforCourse(int year, int term, Integer coid, Integer pid) {
        return setStudentList(profDAO.profCourseStudents(year,term,coid,pid),profDAO.getProf(pid).getCourses());
    }

    private List<MyStudent> setStudentList(List<StCot> aVoid, List<TermCot> courses) {
        List<MyStudent> m = new ArrayList<>();
        for(StCot sc:aVoid){
            for(TermCot tc:courses)
            {
                if(tc.getId().getCourse().equals(sc.getCourse().getId()))
                    m.add(new MyStudent(sc.getStudent().getName(),sc.getStudent().getId()));
            }
        }//TODO might wrong
        return m;

    }

    private List<Courses> makeCourseNameList(List<TermCot> termcourses,Integer year, Integer term)
    {
        List<Courses> output = new ArrayList<>();
        for(TermCot tc : termcourses)
        {
            System.out.println(tc.getId().getTerm());
            System.out.println(term);
            System.out.println(tc.getId().getYear());
            System.out.println(year);
            System.out.println("--------------------");
            if(tc.getId().getTerm().equals(term) && tc.getId().getYear().equals(year))
            {

                output.add(new Courses(tc.getTermCourse().getName(),
                                tc.getTermCourse().getId()
                        ,tc.getId().getCoursegroup()));
            }
        }

        return output;

    }

}
