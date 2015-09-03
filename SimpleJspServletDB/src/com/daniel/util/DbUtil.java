package com.daniel.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbUtil 
{
	private static Connection con=null;
	
	public static Connection getConnection()
	{
	if(con!=null)
	{
		return con;
	}
	else
	{
		try
		{
			Properties prop = new Properties();
			InputStream ip = DbUtil.class.getClassLoader().getResourceAsStream("/db.properties");
			prop.load(ip);
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String pwd = prop.getProperty("password");
			
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, user, pwd);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	return con;
	}
}