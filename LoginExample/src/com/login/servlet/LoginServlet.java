package com.login.servlet;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.bean.LoginBean;
import com.login.dao.LoginDao;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException
    {
    	try
    	{
    		LoginBean bean = new LoginBean();
    		bean.setUsername(req.getParameter("username"));
    		bean.setPassword(req.getParameter("password"));
    		 bean = LoginDao.login(bean);
    		 
    		 if(bean.isValid())
    		 {
    			 HttpSession session = req.getSession(true);
    			 session.setAttribute("loginuser",bean);
    			 resp.sendRedirect("validLogin.jsp");
    		 }
    		 else
    		 {
    			 resp.sendRedirect("invalidLogin.jsp");
    		 }
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
}
