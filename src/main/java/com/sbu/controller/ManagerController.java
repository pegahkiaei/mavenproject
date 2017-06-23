/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbu.controller;


//import com.sbu.dao.model.Dept;

import com.sbu.dao.model.Dept;
import com.sbu.service.impl.TheManagerManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/themanagers")
public class ManagerController {


    @Autowired
    private TheManagerManagerImpl managerManagerImpl;

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String findManager(HttpServletRequest request, @RequestParam("username") String  usernname , @RequestParam("password") String password , Model model){
        //Dept d =null;// managerManagerImpl.getUserByUname(usernname,password);
        Dept d= managerManagerImpl.getDeptByManagerId(usernname,password);
        if(d != null){
        //TODO: connecting manager
            int deptId=d.getId();
            model.addAttribute("name",usernname);//manager.getName()
            request.getSession().setAttribute("id",d.getId());
            request.getSession().setAttribute("type","m");
            request.getSession().setAttribute("name","ramak");
            return "themanager/managerFirstPage";
       }
        else
        {
            return "themanager/managerLogin";
        }

    }

    @RequestMapping(value="/infoEdit", method=RequestMethod.POST)
    public String editManager(HttpServletRequest req, @RequestParam("username") String  usernname , @RequestParam("password") String password , Model model) {
        int id= (Integer) req.getSession().getAttribute("id");

        boolean isUpdated=managerManagerImpl.updateUserPass(id,usernname,password);
        System.err.println("$$$$$$$$$$$$$$"+isUpdated);
        Dept d= managerManagerImpl.getDeptByManagerId(usernname,password);
        if (d!=null)
             System.err.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+d.getUname()+d.getPassword()+"steve jobs");
        return "themanager/managerFirstPage";

    }

    @RequestMapping(value="/infoEdit", method=RequestMethod.GET)
    public String showeditManager(HttpServletRequest req, Model model) {

        return "themanager/managerInfoEdit";

    }

    @RequestMapping(method = RequestMethod.POST)
    public String toLogin(Model model) {
        // Return view welcome. Via resolver the view
        // will be mapped to /WEB-INF/jsp/welcome.jsp
        return "themanager/managerLogin";
    }
}

