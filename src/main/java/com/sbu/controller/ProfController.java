/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbu.controller;

import com.google.gson.Gson;
import com.sbu.controller.model.Courses;
import com.sbu.controller.model.MyStudent;
import com.sbu.dao.model.Prof;
import com.sbu.service.ProfManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.*;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/prof")
public class ProfController {

    @Autowired
    public ProfManager profManager;

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String findProf(HttpServletRequest request,@RequestParam("username") String  usernname ,
                           @RequestParam("password") String password , Model model)
    {
        Prof p =null;// profManager.getUserByUname(usernname,password);
        p = profManager.getUserByUname(usernname,password);

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
    public String insert(Model model)
    {
        return "prof/profLogin";
    }


    @RequestMapping(value="/infoEdit", method=RequestMethod.POST)
    public String editprof(HttpServletRequest req, @RequestParam("username") String  usernname ,
                           @RequestParam("password") String password , Model model)
            throws HeuristicRollbackException, HeuristicMixedException, NotSupportedException, RollbackException, SystemException
    {
        int id= (Integer) req.getSession().getAttribute("id");

        boolean isUpdated=profManager.updateUserPass(id,usernname,password);
        System.err.println("$$$$$$$$$$$$$$"+isUpdated);
        Prof d= profManager.getProfByManagerId(usernname,password);
        if (d!=null)
            System.err.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+d.getUname()+d.getPass()+"steve jobs");
        return "prof/profFirstPage";

    }
    @RequestMapping(value="/infoEdit", method=RequestMethod.GET)
    public String showeditManager(HttpServletRequest req, Model model)
    {

        return "prof/profInfoEdit";

    }


    @RequestMapping(value="/listPage", method=RequestMethod.GET)
    public ModelAndView showListOfStudents(HttpServletRequest req, Model model)
    {
       ModelAndView termsModel =
               new ModelAndView("prof/profStudentList");
        return termsModel;

    }

    //PEGAH
    @RequestMapping(value ="/chooseTY")
    public void getCourseList(HttpServletRequest request, HttpServletResponse response,
                              @RequestParam("year") String year, @RequestParam("term") String term ) throws IOException
    {
                HttpSession s = request.getSession();
                List<Courses> details = profManager.getCoursesByProfId(Integer.parseInt(year),Integer.parseInt(term),(Integer)s.getAttribute("id"));
                String json = new Gson().toJson(details);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(json);
                response.getWriter().flush();

    }
    @RequestMapping(value ="/chooseTY",method = RequestMethod.POST)
    public void getCourseStudents(HttpServletRequest request, HttpServletResponse response,
                                  @RequestParam("year") String year, @RequestParam("term") String term,@RequestParam("coid") String coid) throws IOException {
        HttpSession s = request.getSession();
        List<MyStudent> details = profManager.getstudentforCourse(Integer.parseInt(year),Integer.parseInt(term),(Integer)Integer.parseInt(coid),(Integer)s.getAttribute("id"));
        String json = new Gson().toJson(details);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
        response.getWriter().flush();
    }

}

