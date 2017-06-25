package com.sbu.dao;

import com.sbu.dao.model.StCot;
import com.sbu.dao.model.Stt;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SttDAO {

	Stt getStt(String uname);

	List<StCot> getStudentCoursesByStId(String name, Integer id);

	List<StCot> getStudentCoursesByStIdANDterm(Integer term, Integer id);

	Stt getStu(String sttId);
	Stt getStt(String profId, String profPass);
	Stt getStt(int sttId);

	void updateStt(Stt stt, String usernname, String password);
}
