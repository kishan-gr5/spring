package com.customer.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InsertCustomer extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
      
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException
	{
		try
		{
			String name = req.getParameter("name");
			String address = req.getParameter("address");
			String mobile = req.getParameter("mobile");
			String emailid = req.getParameter("emailid");
		
			Customer cust = new Customer();
			cust.setName(name);
			cust.setAddress(address);
			cust.setMobile(mobile);
			cust.setEmailid(emailid);
			
			RequestDispatcher rd = req.getRequestDispatcher("/Welcome.jsp");
			req.setAttribute("customer",cust);
			rd.forward(req,resp);
	}catch(ServletException s){
		s.printStackTrace();
	}catch(IOException i){
		i.printStackTrace();
	}catch(Exception e){
		e.printStackTrace();
	}
	}
}
