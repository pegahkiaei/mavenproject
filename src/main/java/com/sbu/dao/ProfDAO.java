package com.sbu.dao;

import com.sbu.dao.model.Cot;
import com.sbu.dao.model.Prof;
import com.sbu.dao.model.Stt;

import java.util.List;

/**
 * Created by Nia on 6/25/2017.
 */
public interface ProfDAO {
    Prof getProfByDeptId(String uname);

    List<Integer> getTermCot(Prof p);

    List<Cot> getCot(int tid);

    List<Stt> getStudent(String course);

    void updateDept(Prof p, String usernname, String password);

    Prof getProfByDeptId(int id);

    Prof getProfByDeptId(String username, String password);

    Prof getProf(Integer pid);
    List profCourseStudents(int year, int term, Integer coid, Integer pid);
}
