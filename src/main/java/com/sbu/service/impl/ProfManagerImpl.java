package com.sbu.service.impl;

import com.sbu.dao.impl.ProfDAOImpl;
import com.sbu.dao.model.Cot;
import com.sbu.dao.model.Dept;
import com.sbu.dao.model.Prof;
import com.sbu.dao.model.Stt;
import com.sbu.service.ProfManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProfManagerImpl implements ProfManager {

    public ProfManagerImpl() {
    }

    @Autowired
    public ProfDAOImpl profDAOImpl;

    @Override
    public List<Integer> getTermIDByProf(Prof p) {
        List<Integer> termIds =profDAOImpl.getTermCot(p);
        return termIds;
    }
    @Override
    public List<Cot>getCotBytermId(int tid){
        List<Cot>CoName = profDAOImpl.getCot(tid);
        return CoName;
    }
    @Override
    public   List<Stt> getStudentBycourse(String course){
        List<Stt>stnames = profDAOImpl.getStudent(course);
        return stnames;

    }

    @Override
    public Boolean updateUserPass(int id, String usernname, String password)  {
        Dept dept = profDAOImpl.getDept(id); // who is this?
        Dept possibleDup = profDAOImpl.getDept(usernname);//maybe this username is taken
        Dept newDep = null;
        if (possibleDup == null || (possibleDup != null && possibleDup.getId() == dept.getId())) {//username is not taken
            System.err.println("%%%%%%%%%%%%%%%%%%%%% going to update it!!");
            dept.setUname(usernname);
            System.err.println(usernname);
            dept.setPassword(password);
            profDAOImpl.updateDept(dept,usernname,password);
            newDep=profDAOImpl.getDept(id);
            System.err.println("newDep data here            : " + newDep.getId() + "// " + newDep.getUname());
        }

        Boolean isUpdated = (null != newDep && newDep.getId() == dept.getId());
        return isUpdated;
    }
    @Override
    public Dept getDeptByDeptId(int id) {
        Dept d = profDAOImpl.getDept(id);
        return (d!=null? d:null);
    }

    @Override
    public Dept getDeptByManagerId(String username, String password) {
        Dept d=profDAOImpl.getDept(username,password);
        return (d!=null? d:null);

    }

    @Override
    public Prof getUserByUname(String uname, String pass) {
        Prof p = profDAOImpl.getProf(uname);
        //return (p.getPassword().equals(pass)?p:null);
        return (p!= null && p.getPass().equals(pass)? p : null);
    }

}
