/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbu.controller;

import com.sbu.dao.model.Cot;
import com.sbu.dao.model.Prof;
import com.sbu.service.impl.ProfManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(value="/infoEdit", method=RequestMethod.GET)
    public String showeditProf(HttpServletRequest req, Model model) {

        return "prof/profInfoEdit";

    }
    @RequestMapping(value="/listPage", method=RequestMethod.GET)
    public String showListOfStudents(HttpServletRequest req, Model model) {
        boolean stuCountZero=false;
        List<Cot> c= new ArrayList<Cot>();
        Cot c1=new Cot();
        c1.setName("ددی");
        c1.setId(1);
        Cot c2=new Cot();
        c2.setName("دادادی");
        c2.setId(2);
        c.add(c1);
        c.add(c2);
        model.addAttribute("students",c);
        model.addAttribute("isEmpty",stuCountZero);
        return "prof/profStudentList";

    }

}

