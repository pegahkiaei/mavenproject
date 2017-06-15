/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbu.controller;


//import com.sbu.dao.model.Dept;
import com.sbu.dao.model.Dept;
import com.sbu.dao.model.Stt;
import com.sbu.service.impl.ManagerManagerImpl;
import com.sbu.service.impl.ProfManagerImpl;
import com.sbu.service.impl.UserManagerImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/managerLogin")
public class ManagerController {

    @Autowired
    public ManagerManagerImpl managerManagerImpl;
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String findStudent(@RequestParam("username") String  usernname , @RequestParam("password") String password , Model model){
        Dept d =null;// managerManagerImpl.getUserByUname(usernname,password);
//        if(d != null){
            //TODO: connecting manager
            model.addAttribute("name",usernname);//d.getName()
            return "manager/managerFirstPage";
//        }
//        else
//        {
//            return "manager/managerLogin";
//        }

    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String toLogin(Model model) {
        // Return view welcome. Via resolver the view
        // will be mapped to /WEB-INF/jsp/welcome.jsp       
        return "manager/managerLogin";
    }
}
