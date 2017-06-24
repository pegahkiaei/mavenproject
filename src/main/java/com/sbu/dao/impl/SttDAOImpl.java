/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbu.dao.impl;


import com.sbu.dao.SttDAO;
import com.sbu.dao.model.StCot;
import com.sbu.dao.model.Stt;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pegah
 */
@Repository
public class SttDAOImpl implements SttDAO {
    public SttDAOImpl() {
    }
    
    @PersistenceContext
    public EntityManager entityManager;


    @Override
    @Transactional
    public Stt getStt(String uname) {
        String hql = "SELECT s FROM Stt s WHERE s.uname=:userName";
        Query query = entityManager.createQuery(hql);
        query.setParameter("userName",uname);
        List<Stt> res = (List<Stt>) query.getResultList();
        return res == null || res.size() == 0 ? null : res.get(0);
    }

    @Transactional
    @Override
    public List<StCot> getStudentCoursesByStId(String name, Integer id) {
        return entityManager.createQuery("SELECT sc FROM StCot sc where sc.student.id=:idnumber").setParameter("idnumber",id).getResultList();
    }

    @Override
    public List<StCot> getStudentCoursesByStIdANDterm(Integer term, Integer id) {
        return entityManager.createQuery("SELECT sc FROM StCot sc where sc.student.id=:idnumber and sc.term=:courseterm")
                .setParameter("idnumber",id)
                .setParameter("courseterm",term)
                .getResultList();
    }


    public EntityManager getEntityManager() {
        return entityManager;
    }
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
