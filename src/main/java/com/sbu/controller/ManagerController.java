/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbu.controller;


//import com.sbu.dao.model.Dept;

import com.sbu.dao.model.Cot;
import com.sbu.dao.model.Dept;
import com.sbu.dao.model.SubMajt;
import com.sbu.service.impl.TheManagerManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.*;
import java.util.ArrayList;
import java.util.List;

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
            String managerName=d.getManager().getName();
            model.addAttribute("name",managerName);//manager.getName()
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
    public String editManager(HttpServletRequest req, @RequestParam("username") String  usernname , @RequestParam("password") String password , Model model) throws HeuristicRollbackException, HeuristicMixedException, NotSupportedException, RollbackException, SystemException {
        int id= (Integer) req.getSession().getAttribute("id");

        boolean isUpdated=managerManagerImpl.updateUserPass(id,usernname,password);
        System.err.println("$$$$$$$$$$$$$$"+isUpdated);
        Dept d= managerManagerImpl.getDeptByManagerId(usernname,password);
        if (d!=null)
             System.err.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+d.getUname()+d.getPassword()+"steve jobs");
        return "themanager/managerFirstPage";

    }

    @RequestMapping(value="/addCourse", method=RequestMethod.POST)
    public String addCourseToDB(HttpServletRequest req, @RequestParam("courseName") String cName,
                                @RequestParam("creditCounter") String cCount, @RequestParam("pre") String cHasPre,
                                @RequestParam("preCourses") String listOfPre,
                                Model model) {
        System.err.println("here in controller");
        int id= (Integer) req.getSession().getAttribute("id");
        Dept d = managerManagerImpl.getDeptByDeptId(id);
        int groups=  d.getSubMajors().size();
        String subs=null;
        if(groups!=0){
            subs= req.getParameter("group");
        }
        Cot c = managerManagerImpl.addNewCourse(cName,cCount,cHasPre,listOfPre,subs,id);
        System.err.println("course name is " + cName + " credit is "+cCount + "has pre? :  " + cHasPre + "preCourses are : "+ listOfPre+ " available for "+ subs);

        return "themanager/managerFirstPage";

    }


    @RequestMapping(value="/addEditCourse", method=RequestMethod.GET)
    public String showAddEditCourse(HttpServletRequest req, HttpServletResponse response, Model model) {
        int id= (Integer) req.getSession().getAttribute("id");
        Dept d = managerManagerImpl.getDeptByDeptId(id);

        //List<Cot> courses = d.getDeptCourses();
        //List<SubMajt> subMajors = d.getSubMajors();
        List<SubMajt> subMajors = new ArrayList<SubMajt>();
        model.addAttribute("subs", subMajors);
        model.addAttribute("isEmpt", !subMajors.isEmpty());
        //model.addAttribute("subCount",subMajors.isEmpty());
        //model.addAttribute("cots", courses);
        //model.addAttribute("cots",!courses.isEmpty());

        return "themanager/managerEditCourse";

    }

    @RequestMapping(value="/getOut", method=RequestMethod.GET)
    public String tipHimOut(HttpServletRequest req, Model model) {
        model.addAttribute("type", null);
        return "themanager/managerInfoEdit";

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

