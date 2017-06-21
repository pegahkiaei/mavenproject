/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbu.dao.impl;


import com.sbu.dao.model.Stt;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 *
 * @author Pegah
 */
@Repository
public class SttDAOImpl {
    public SttDAOImpl() {
    }
    
    @PersistenceContext
    public EntityManager entityManager;
    
    @Transactional
    public Stt getStt(String uname) {
        String hql = "SELECT s FROM Stt s WHERE s.uname=:userName";
        Query query = entityManager.createQuery(hql);
        query.setParameter("userName",uname);
        List<Stt> res = (List<Stt>) query.getResultList();
        return res == null || res.size() == 0 ? null : res.get(0);
    }
    /*   CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = builder.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);
        return entityManager.createQuery(cq).getResultList();*/
    
//    public List<Stt> findAllStt() {
//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Stt> cq = builder.createQuery(Stt.class);
//        Root<Stt> root = cq.from(Stt.class);
//        cq.select(root);
//        return entityManager.createQuery(cq).getResultList();
//    }


    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
