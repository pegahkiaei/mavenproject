/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbu.controller;

import com.sbu.dao.model.Cot;
import com.sbu.dao.model.Prof;
import com.sbu.dao.model.Stt;
import com.sbu.service.impl.ProfManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/prof")
public class ProfController {

    @Autowired
    public ProfManagerImpl profManagerImpl;

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String findProf(HttpServletRequest request,@RequestParam("username") String  usernname , @RequestParam("password") String password , Model model){
        Prof p =null;// profManagerImpl.getUserByUname(usernname,password);
        p = profManagerImpl.getUserByUname(usernname,password);

        if(p != null) {
            // model.addAttribute("name",usernname);//p.getName()


            request.getSession().setAttribute("id", p.getId());
            request.getSession().setAttribute("name", p.getName());
            request.getSession().setAttribute("type", "p");
            model.addAttribute("name", p.getName());
            return "prof/profFirstPage";
            //where to set sessions
        }

        else
        {
            return "prof/peofLogin";
        }

    }

    @RequestMapping(method = RequestMethod.POST)
    public String insert(Model model) {        
        return "prof/profLogin";
    }


    @RequestMapping(value="/infoEdit", method=RequestMethod.POST)
    public String editprof(HttpServletRequest req, @RequestParam("username") String  usernname , @RequestParam("password") String password , Model model) throws HeuristicRollbackException, HeuristicMixedException, NotSupportedException, RollbackException, SystemException {
        int id= (Integer) req.getSession().getAttribute("id");

        boolean isUpdated=profManagerImpl.updateUserPass(id,usernname,password);
        System.err.println("$$$$$$$$$$$$$$"+isUpdated);
        Prof d= profManagerImpl.getProfByManagerId(usernname,password);
        if (d!=null)
            System.err.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+d.getUname()+d.getPass()+"steve jobs");
        return "prof/profFirstPage";

    }
    @RequestMapping(value="/infoEdit", method=RequestMethod.GET)
    public String showeditManager(HttpServletRequest req, Model model) {

        return "prof/profInfoEdit";

    }


    @RequestMapping(value="/listPage", method=RequestMethod.GET)
    public String showListOfStudents(HttpServletRequest req, Model model) {
        int id=Integer.parseInt(req.getParameter("id"));
        Prof p=profManagerImpl.getProfByDeptId(id);
        List<Stt> s= new ArrayList<Stt>();
        List<Cot> c = new ArrayList<Cot>();
        boolean stuCountZero=s.isEmpty();
        boolean courseCountZero=c.isEmpty();
        model.addAttribute("courses",c);
        model.addAttribute("isEmptyC",courseCountZero);
        model.addAttribute("students",s);
        model.addAttribute("isEmpty",stuCountZero);
        return "prof/profStudentList";

    }

    //PEGAH


}

