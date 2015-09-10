package com.daniel.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil 
{
	private static Connection con=null;
	
	public static Connection getconnection()
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
		catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return con;
	}
}
}
