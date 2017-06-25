/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbu.controller;

import com.google.gson.Gson;
import com.sbu.controller.model.CourseDetail;
import com.sbu.controller.model.TermDetail;
import com.sbu.controller.model.TermsData;
import com.sbu.dao.model.Stt;
import com.sbu.service.SttManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private SttManager sttManager;

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, @RequestParam("username") String  usernname , @RequestParam("password") String password , Model model)
    {
        Stt s = sttManager.getStudentByUname(usernname,password);
        if(s != null){
            request.getSession().setAttribute("id",s.getId());
            request.getSession().setAttribute("name",s.getName());
            request.getSession().setAttribute("type","s");
            model.addAttribute("name",s.getName());
            return "student/studentFirstPage";
            //where to set sessions
        }
        else
        {
            return "student/studentLogin";
        }

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request,HttpServletResponse Response)
    {
        request.getSession().invalidate();
        return "welcome";
    }

    @RequestMapping(value="/transcript", method = RequestMethod.GET)
    public ModelAndView getTranscript(HttpServletRequest request)
    {
        if(request.getSession(false)!=null && request.getSession(false).getAttribute("type").equals("s"))
        {
            HttpSession s = request.getSession();
            //bring the first table content then other tables will be brought by other requests!
            TreeMap<Integer,TermsData> briefTermsData = sttManager.getBriefTableContext((String) s.getAttribute("name"),
                    (Integer)s.getAttribute("id"));
            ModelAndView termsModel = new ModelAndView("student/transcript","terms",briefTermsData);
            return termsModel;
        }
        else
        {
            return new ModelAndView("student/studentLogin");
        }
    }

    @RequestMapping(value="/transcript_detail", method = RequestMethod.POST)
    public void termDetail(HttpServletRequest request, HttpServletResponse response, @RequestParam("term") String term)throws ServletException, IOException
    {//https://stackoverflow.com/questions/4112686/how-to-use-servlets-and-ajax
        HttpSession s = request.getSession();
        List<TermDetail> details = sttManager.getTermDetail(Integer.parseInt(term), (Integer) s.getAttribute("id"));
        String json = new Gson().toJson(details);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
        response.getWriter().flush();
    }

    @RequestMapping(value = "/course_detail", method = RequestMethod.POST)
    public void courseDetail(HttpServletRequest request, HttpServletResponse response, @RequestParam("cid") String cid, @RequestParam("term") String term)throws ServletException, IOException
    {//https://stackoverflow.com/questions/4112686/how-to-use-servlets-and-ajax
        HttpSession s = request.getSession();
        CourseDetail detail = sttManager.getCourseDetail(Integer.parseInt(cid), (Integer) s.getAttribute("id"), Integer.parseInt(term));
        String json = new Gson().toJson(detail);
        System.out.println("INSERVER"+cid+" "+term);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
        response.getWriter().flush();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String toLogin(Model model) {
        return "student/studentLogin";
    }

    @RequestMapping(value ="/InfoEdit" , method = RequestMethod.GET)
    public String stInfoEdit(Model model){
        return "student/studentInfoEdit";
    }

    @RequestMapping(value="/infoEdit", method=RequestMethod.POST)
    public String editStt(HttpServletRequest req, @RequestParam("username") String  usernname , @RequestParam("password") String password , Model model) {
        int id= (Integer) req.getSession().getAttribute("id");
        boolean isUpdated=sttManager.updateUserPass(id,usernname,password);
        Stt d= sttManager.getSttByManagerId(usernname,password);
        return "student/studentFirstPage";
    }





}