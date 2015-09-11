package com.login.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.login.bean.LoginBean;
import com.login.dbUtil.LogindbUtil;

public class LoginDao
{
	static Connection con = null;
	static ResultSet rs = null;
	
	public static LoginBean login(LoginBean bean)
	{
		String username = bean.getUsername();
		String password =bean.getPassword();
		
		String query = "select * from logintable where username= "+username + " and password= "+password;
		
		 System.out.println("Your user name is " + username);          
	      System.out.println("Your password is " + password);
	      System.out.println("Query: "+query);
		    
		try
		{
		con = LogindbUtil.getconnection();
		Statement st = con.createStatement();
		rs= st.executeQuery(query);
		boolean more = rs.next();
		if(more)
		{
			String fname = rs.getString("firstname");
			String lname = rs.getString("lastname");
			System.out.println("Welcome "+ fname);
			bean.setFirstname(fname);
			bean.setLastname(lname);
			bean.setValid(more);
		}
		else
		{
			System.out.println("You are not registered");
			bean.setValid(more);
		}
		}catch(SQLException s)
		{
			s.printStackTrace();
		}
		return bean;
	}
}
