package com.sbu.service;

import com.sbu.dao.model.Cot;
import com.sbu.dao.model.Dept;
import com.sbu.dao.model.Prof;
import com.sbu.dao.model.Stt;

import java.util.List;


public interface ProfManager {
    List<Integer> getTermIDByProf(Prof p);
    Prof getUserByUname(String uname, String pass);
    List<Cot>getCotBytermId(int tid);
    List<Stt> getStudentBycourse(String course);
    Boolean updateUserPass(int id, String usernname, String password);
    Dept getDeptByDeptId(int id);
    Dept getDeptByManagerId(String username, String password);
}