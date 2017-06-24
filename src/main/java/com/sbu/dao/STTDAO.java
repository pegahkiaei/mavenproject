package com.sbu.dao;

import java.util.List;

import com.sbu.dao.model.StCot;
import com.sbu.dao.model.Stt;
import org.springframework.stereotype.Repository;

@Repository
public interface SttDAO {

	Stt getStt(String uname);

	List<StCot> getStudentCoursesByStId(String name, Integer id);

	List<StCot> getStudentCoursesByStIdANDterm(Integer term, Integer id);
}
