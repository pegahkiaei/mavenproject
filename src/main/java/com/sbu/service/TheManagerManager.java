package com.sbu.service;

import com.sbu.dao.model.Cot;
import com.sbu.dao.model.Dept;

import javax.transaction.*;

/**
 * Created by Pegah on 5/29/2017.
 */
public interface TheManagerManager {
    Dept getDeptByManagerId(String usernname, String id);

    Dept getDeptByDeptId(int id);

    Boolean updateUserPass(int id, String usernname, String password) throws HeuristicRollbackException, HeuristicMixedException, NotSupportedException, RollbackException, SystemException;

    Cot addNewCourse(String cName, String cCount, String cHasPre, String listOfPre, String cGroup, int id);
}
