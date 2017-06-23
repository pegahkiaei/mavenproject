package com.sbu.service.impl;

import com.sbu.dao.impl.TheManagerDAOImpl;
import com.sbu.dao.model.Dept;
import com.sbu.service.TheManagerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Pegah on 5/29/2017.
 */
@Service
public class TheManagerManagerImpl implements TheManagerManager {

    public TheManagerManagerImpl() {
    }

    @Autowired
    public TheManagerDAOImpl managerDAOImpl;

    @Override
    public Dept getDeptByManagerId(String username, String password) {
        Dept d=managerDAOImpl.getDept(username,password);
        return (d!=null? d:null);

    }
    @Override
    public Boolean updateUserPass(int id, String usernname, String password) {
        Dept dept=managerDAOImpl.getDept(id); // who is this?
        Dept possibleDup=managerDAOImpl.getDept(usernname);//maybe this username is taken
        Dept newDep=null;
        if(possibleDup==null || (possibleDup!=null && possibleDup.getId()==dept.getId())){//username is not taken
            System.err.println("%%%%%%%%%%%%%%%%%%%%% going to update it!!");
            newDep=managerDAOImpl.updateDept(dept.getId(),usernname,password);
            System.err.println("newDep data here            : " + newDep.getId() + "// "+newDep.getUname());
            Dept newnewDept = managerDAOImpl.getDept(id);
            if(newnewDept!=null)
                System.err.println("&& newnewDep data here            : " + newnewDept.getId() + "// "+newnewDept.getUname());
        }
        Boolean isUpdated=(null!=newDep && newDep.getId()==dept.getId());
        return isUpdated;
    }


//
//    @Autowired
//    public ManagerDAOImpl managerDAOImpl;
//
//    @Override
//    public Dept getUserByUname(String uname, String pass) {
//        Dept d = managerDAOImpl.getMan(uname);
//        return (d.getPassword().equals(pass)?s:null);
//    }
}
