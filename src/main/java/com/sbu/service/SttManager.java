/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbu.service;

import com.sbu.controller.model.CourseDetail;
import com.sbu.controller.model.TermDetail;
import com.sbu.controller.model.TermsData;
import com.sbu.dao.model.Stt;

import java.util.List;
import java.util.TreeMap;


/**
 *
 * @author Pegah
 */
public interface SttManager {

    Stt getStudentByUname(String uname,String pass);

    TreeMap<Integer,TermsData> getBriefTableContext(String name, Integer id);

    List<TermDetail> getTermDetail(Integer term, Integer id);
    CourseDetail getCourseDetail(Integer cid, Integer id, Integer term);
}
