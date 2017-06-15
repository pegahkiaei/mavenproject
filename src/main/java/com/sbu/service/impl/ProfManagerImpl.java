package com.sbu.service.impl;

import com.sbu.dao.impl.SttDAOImpl;
import com.sbu.dao.model.Prof;
import com.sbu.dao.model.Stt;
import com.sbu.service.ProfManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Pegah on 5/29/2017.
 */
@Service
public class ProfManagerImpl implements ProfManager {

    public ProfManagerImpl() {
    }

//    @Autowired
//    public ProfDAOImpl profDAOImpl;

//    @Override
//    public Prof getUserByUname(String uname, String pass) {
//        Prof p = profDAOImpl.getProf(uname);
//        return (p.getPassword().equals(pass)?p:null);
//    }

}
