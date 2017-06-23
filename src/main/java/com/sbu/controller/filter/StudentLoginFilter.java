package com.sbu.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Nia on 6/20/2017.
 */
@WebFilter("/student/*")/*check for all urls */
public class StudentLoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        String loginURI = request.getContextPath() + "/student"; /* student login page */
        String stuFirstPage = request.getContextPath() + "/student/login"; /* student login page */
        //String mainPage = request.getContextPath() + "/"; /* ?! */

        boolean loggedIn = (session != null) && (session.getAttribute("type") != null) && (session.getAttribute("type") == "s");
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        //boolean isMainPage = request.getRequestURI().equals(mainPage);
        boolean isFirstPage= request.getRequestURI().equals(stuFirstPage);
        boolean isStaticResource = request.getRequestURI().startsWith("/resources/");

        if (loggedIn || loginRequest||isStaticResource || isFirstPage) { //if: user is logged in, or user is attempting to login, or user is just looking at the main page and has nothing to do with us
            chain.doFilter(request, response);//let it go :d
        } else {
            System.err.println("123123123123123123123123123123123123123123123123123123123" + request.getRequestURI() + isFirstPage + loginRequest );
            response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
            response.setHeader("Location", loginURI);
            //response.sendRedirect(loginURI); //redirect user to login page!! this user mustn't be here!
        }
    }

    @Override
    public void destroy() {

    }

    // ...
}