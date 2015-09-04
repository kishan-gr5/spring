package com.daniel.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daniel.dao.UserDao;
import com.daniel.model.User;


public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/user.jsp";
	private static String LIST_USER = "/listUser.jsp";
    private UserDao dao;   
   
    public UserController() {
        super();
        dao = new UserDao();
       
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException
    {
    	String forward= "";
    	String action = req.getParameter("action");
    	if(action.equalsIgnoreCase("delete"))
    	{
    		forward=LIST_USER;
    		int userid = Integer.parseInt(req.getParameter("userid"));
    		dao.deleteUser(userid);
    		req.setAttribute("users",dao.getAllUsers());
    	}
    	else if(action.equalsIgnoreCase("edit"))
    	{
    		forward=INSERT_OR_EDIT;
    		int userid = Integer.parseInt(req.getParameter("userid"));
    		User user= dao.getUserById(userid);
    		req.setAttribute("users",user);
    	}
    	else if(action.equalsIgnoreCase("listUser"))
    	{
    		forward=LIST_USER;
    		req.setAttribute("users", dao.getAllUsers());
    	}
    	else
    	{
    		forward=INSERT_OR_EDIT;
    	}
    	RequestDispatcher rd = req.getRequestDispatcher(forward);
    	rd.forward(req,resp);
    }
	
    public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException
    {
    	User user = new User();
    	
    	user.setFirstname(req.getParameter("firstname"));
    	user.setLastname(req.getParameter("lastname"));
    	try {
			user.setDob(new SimpleDateFormat("MM/dd/yyyy").parse(req.getParameter("dob")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	user.setEmailid(req.getParameter("emailid"));
    	String userid = req.getParameter("userid");
    	if(userid == null || userid.isEmpty())
    	{
    		dao.addUser(user);
    	}else
    	{
    		user.setUserid(Integer.parseInt(userid));
    		dao.updateUser(user);
    	}
    	RequestDispatcher rd = req.getRequestDispatcher(LIST_USER);
    	req.setAttribute("users",dao.getAllUsers());
    	rd.forward(req,resp);
    }

}
