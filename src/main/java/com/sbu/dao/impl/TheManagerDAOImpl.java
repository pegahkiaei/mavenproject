package com.sbu.dao.impl;


import com.sbu.dao.model.Cot;
import com.sbu.dao.model.Dept;
import com.sbu.dao.model.Prof;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Nia on 6/21/2017.
 */
@Repository
public class TheManagerDAOImpl {

    public TheManagerDAOImpl() {
    }

    @PersistenceContext
    public EntityManager entityManager ;



    @Transactional
    public Prof getManager(String usern){
        String hql="SELECT p FROM Dept  p WHERE p.uname=:username";
        Query q= entityManager.createQuery(hql);
        q.setParameter("username",usern);
        List<Prof> res = (List<Prof>) q.getResultList();
        return res == null || res.size() == 0 ? null : res.get(0);
    }
    @Transactional
    public Dept getDept(int deptId) {
        String hql= "SELECT d FROM Dept  d WHERE  d.id=:idHere";
        Query q= entityManager.createQuery(hql);
        q.setParameter("idHere",deptId);
        List<Dept> res = (List<Dept>) q.getResultList();
        return res == null || res.size() == 0 ? null : res.get(0);
    }
    @Transactional
    public Dept getDept(String managerId, String managerPass) {
        String hql= "SELECT d FROM Dept  d WHERE d.uname=:username AND d.password=:pass";
        Query q= entityManager.createQuery(hql);
        q.setParameter("username",managerId);
        q.setParameter("pass",managerPass);
        List<Dept> res = (List<Dept>) q.getResultList();
        return res == null || res.size() == 0 ? null : res.get(0);
    }

    @Transactional
    public Dept getDept(String managerId) {
        String hql= "SELECT d FROM Dept  d WHERE d.uname=:username";
        Query q= entityManager.createQuery(hql);
        q.setParameter("username",managerId);
        List<Dept> res = (List<Dept>) q.getResultList();
        return res == null || res.size() == 0 ? null : res.get(0);
    }

    @Transactional
    public Cot newCourse(String cName, String cCount, String cHasPre, String listOfPre, String cGroup, int depId) {
        Cot cot=new Cot();
        Dept d=getDept(depId);
        cot.setCourseDept(d);
        cot.setCredit(Integer.parseInt(cCount));
        cot.setName(cName);

        return cot;
    }
    @Transactional
    public  void updateDept(Dept dep,String username, String password)  {
        entityManager.clear();
        dep.setUname(username);
        dep.setPassword(password);
        entityManager.merge(dep);
    }//end of update Dept


}
