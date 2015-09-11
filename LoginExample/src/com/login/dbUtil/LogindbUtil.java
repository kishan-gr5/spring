package com.login.dbUtil;


import java.sql.*;

public class LogindbUtil 
{
	static Connection con = null;

	public static Connection getconnection()
	{
		try
		{
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/logindb";
		String un = "root";
		String pwd = "root";
		
		Class.forName(driver);
		con = DriverManager.getConnection(url,un, pwd);
		
		}catch(Exception e)
		{
		e.printStackTrace();
		}
		return con;
	}
}
