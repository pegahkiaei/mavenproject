/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbu.controller;

import com.sbu.dao.model.Stt;
import com.sbu.service.impl.SttManagerImpl;
import org.h2.engine.Session;
import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/studentLogin")
public class StudentController {

    @Autowired
    private SttManagerImpl sttManagerImpl;
    
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String findStudent(@RequestParam("username") String  usernname , @RequestParam("password") String password ,Model model){
        Stt s = sttManagerImpl.getStudentByUname(usernname,password);
        if(s != null){
        //TODO:connecting s to service
             model.addAttribute("name",s.getName());
             return "student/studentFirstPage";
            //where to set sessions

        }
        else
        {
            return "student/studentLogin";
        }
        
    }
    
   @RequestMapping(method = RequestMethod.POST  )
    public String toLogin(Model model) {
        // Return view welcome. Via resolver the view
        // will be mapped to /WEB-INF/jsp/welcome.jsp       
        return "student/studentLogin";
    }
//   
//   @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
//   public String addStudent(@ModelAttribute("SpringWeb")Student student, Model model) {
//      model.addAttribute("name", student.getName());
//      model.addAttribute("age", student.getAge());
//      model.addAttribute("id", student.getId());
//      return "studentinfo";
//   }
//   
//   @RequestMapping(value = "/addStudent2", method = RequestMethod.POST)
//   public String addStudent2(@ModelAttribute("SpringWeb")Student student, Model model, HttpServletRequest request) {
//      model.addAttribute("name", student.getName());
//      model.addAttribute("age", student.getAge());
//      model.addAttribute("id", student.getId());
//      
//      return "studentinfo";
//   }
}