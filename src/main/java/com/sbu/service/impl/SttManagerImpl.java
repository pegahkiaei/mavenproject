/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbu.service.impl;

import com.sbu.service.SttManager;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbu.dao.impl.SttDAOImpl;
import com.sbu.dao.model.Stt;


/**
 *
 * @author Pegah
 */
@Service
public class SttManagerImpl implements SttManager{
   public SttManagerImpl() {
    }

    @Autowired
    public SttDAOImpl sttDAOImpl;
    
    @Override
    public Stt getStudentByUname(String uname,String pass) {
        Stt s = sttDAOImpl.getStt(uname);
      return (s!= null && s.getPassword().equals(pass)?s:null);
    }
    

    @Override
    public ArrayList<Stt> getAllStudents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }
    
    
    
    
}
