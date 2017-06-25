package com.sbu.dao.impl;

import com.sbu.dao.model.Cot;
import com.sbu.dao.model.Prof;
import com.sbu.dao.model.Stt;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by lenovo on 6/22/2017.
 */
@Repository
public class ProfDAOImpl {
    public ProfDAOImpl() {
    }

    @PersistenceContext
    public EntityManager entityManager;

    @Transactional
    public Prof getProf(String uname) {
        String hql = "SELECT p FROM  Prof p WHERE p.uname=:userName";
        Query query = entityManager.createQuery(hql);
        query.setParameter("userName",uname);
        List<Prof> res = (List<Prof>) query.getResultList();
        return res == null || res.size() == 0 ? null : res.get(0);
    }

    @Transactional
    public List<Integer> getTermCot(Prof p) {
        //String hq= "SELECT s ";
        String hql = "SELECT t.id FROM TermCot  t  WHERE t.courseProfessor=:PROFID";
        Query query = entityManager.createQuery(hql);
        query.setParameter("PROFID",p.getId());
        //List<TermCot> res = (List<TermCot>) query.getResultList();
        List<Integer>res = query.getResultList();

        return res;
        //return res == null || res.size() == 0 ? null : (List<TermCot>) res.get(0);
    }
    @Transactional
    public List<Cot> getCot(int tid){
        String hql = "SELECT t.termCourse FROM TermCot  t  WHERE t.id.term=:termId";
        Query query = entityManager.createQuery(hql);
        query.setParameter("termId",tid);
        List<Cot>res = query.getResultList();
        return res;


    }

    @Transactional
    public Prof getProf(int deptId) {
        String hql= "SELECT d FROM Prof  d WHERE  d.id=:idHere";
        Query q= entityManager.createQuery(hql);
        q.setParameter("idHere",deptId);
        List<Prof> res = (List<Prof>) q.getResultList();
        return res == null || res.size() == 0 ? null : res.get(0);
    }
    @Transactional
    public Prof getprof(String profId) {
        String hql= "SELECT d FROM Prof  d WHERE d.uname=:username";
        Query q= entityManager.createQuery(hql);
        q.setParameter("username",profId);
        List<Prof> res = (List<Prof>) q.getResultList();
        return res == null || res.size() == 0 ? null : res.get(0);
    }
    @Transactional
    public  void updateDept(Prof Pr,String username, String password)  {
        entityManager.clear();
        Pr.setUname(username);
        Pr.setPass(password);
        entityManager.merge(Pr);
    }//end of update Dept

    @Transactional
    public Prof getProf(String profId, String profPass) {
        String hql= "SELECT d FROM Prof  d WHERE d.uname=:username AND d.pass=:pass";
        Query q= entityManager.createQuery(hql);
        q.setParameter("username",profId);
        q.setParameter("pass",profPass);
        List<Prof> res = (List<Prof>) q.getResultList();
        return res == null || res.size() == 0 ? null : res.get(0);
    }

    @Transactional
    public List<Stt> getStudent(String course){
        String hql = "SELECT s.student FROM StCot s WHERE s.course.name=:coName ";
        Query query = entityManager.createQuery(hql);
        query.setParameter("coName",course);
        List<Stt>res = query.getResultList();
        return res;

    }


    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}

