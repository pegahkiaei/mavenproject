package com.sbu.service;

import com.sbu.controller.model.Courses;
import com.sbu.controller.model.MyStudent;
import com.sbu.dao.model.Cot;
import com.sbu.dao.model.Prof;
import com.sbu.dao.model.Stt;

import java.util.List;


public interface ProfManager {
    List<Integer> getTermIDByProf(Prof p);
    Prof getUserByUname(String uname, String pass);
    List<Cot>getCotBytermId(int tid);
    List<Stt> getStudentBycourse(String course);
    Boolean updateUserPass(int id, String usernname, String password);
    Prof getProfByDeptId(int id);
    Prof getProfByManagerId(String username, String password);

    List<Courses> getCoursesByProfId(Integer year, Integer Term, Integer pid );

    List<MyStudent> getstudentforCourse(int year, int term, Integer coid, Integer pid);
}