/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbu.controller;

import com.sbu.dao.model.Prof;
import com.sbu.dao.model.Stt;
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
@RequestMapping("/profLogin")
public class ProfController {

    @Autowired
    public ProfManagerImpl profManagerImpl;

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String findStudent(@RequestParam("username") String  usernname , @RequestParam("password") String password , Model model){
        Prof p =null;// profManagerImpl.getUserByUname(usernname,password);
        //TODO: connecting p to service
//        if(p != null){
            model.addAttribute("name",usernname);//p.getName()
            return "prof/profFirstPage";
//        }
//        else
//        {
//            return "prof/peofLogin";
//        }

    }

    @RequestMapping(method = RequestMethod.POST)
    public String insert(Model model) {        
        return "prof/profLogin";
    }
}

