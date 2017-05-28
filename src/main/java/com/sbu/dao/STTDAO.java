package com.sbu.dao;

import java.util.List;

import com.sbu.dao.model.Stt;
import org.springframework.stereotype.Repository;

@Repository
public interface STTDAO {

	void insertUser(Stt user);

	List<Stt> findAllUsers();
}
