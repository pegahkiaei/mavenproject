package com.sbu.service.impl;

import com.sbu.dao.impl.SttDAOImpl;
import com.sbu.dao.model.Dept;
import com.sbu.dao.model.Stt;
import com.sbu.service.ManagerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Pegah on 5/29/2017.
 */
@Service
public class ManagerManagerImpl implements ManagerManager {

    public ManagerManagerImpl() {
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
