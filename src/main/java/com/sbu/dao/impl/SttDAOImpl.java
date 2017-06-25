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
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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



    @Transactional
    public Stt getStt(int sttId) {
        String hql= "SELECT d FROM Stt  d WHERE  d.id=:idHere";
        Query q= entityManager.createQuery(hql);
        q.setParameter("idHere",sttId);
        List<Stt> res = (List<Stt>) q.getResultList();
        return res == null || res.size() == 0 ? null : res.get(0);
    }
    @Transactional
    public Stt getStu(String sttId) {
        String hql= "SELECT d FROM Stt  d WHERE d.uname=:username";
        Query q= entityManager.createQuery(hql);
        q.setParameter("username",sttId);
        List<Stt> res = (List<Stt>) q.getResultList();
        return res == null || res.size() == 0 ? null : res.get(0);
    }
    @Transactional
    public  void updateStt(Stt stt,String username, String password)  {
        entityManager.clear();
        stt.setUname(username);
        stt.setPassword(password);
        entityManager.merge(stt);
    }//end of update Dept
    @Transactional
    public Stt getStt(String profId, String profPass) {
        String hql= "SELECT d FROM Stt  d WHERE d.uname=:username AND d.password=:pass";
        Query q= entityManager.createQuery(hql);
        q.setParameter("username",profId);
        q.setParameter("pass",profPass);
        List<Stt> res = (List<Stt>) q.getResultList();
        return res == null || res.size() == 0 ? null : res.get(0);
    }


    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
