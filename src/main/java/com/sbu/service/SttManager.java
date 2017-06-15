/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbu.service;

import com.sbu.dao.model.Stt;
import java.util.ArrayList;


/**
 *
 * @author Pegah
 */
public interface SttManager {

    Stt getStudentByUname(String uname,String pass);
    ArrayList<Stt> getAllStudents(); 
}
