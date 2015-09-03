package com.daniel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.daniel.model.User;
import com.daniel.util.DbUtil;

public class UserDao 
{
	private Connection con;
	
	public UserDao()
	{
		con= DbUtil.getConnection();
	}
	
	public void addUser(User user)
	{
		try
		{
		PreparedStatement ps = con.prepareStatement("insert into users(firstname,lastname,dob,emailid) values(?,?,?,?)");
		ps.setString(1,"firstname");
		ps.setString(2,"lastname");
		ps.setDate(3,new java.sql.Date(user.getDob().getTime()));
		ps.setString(4,"emailid");
		
		ps.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void deleteUser(int userid)
	{
		try
		{
			PreparedStatement ps = con.prepareStatement("delete from users where userid=?");
			ps.setInt(1,userid);
			ps.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void updateUser(User user)
	{
		try
		{
			PreparedStatement ps = con.prepareStatement("update user set firstname=?,lastname=?,dob=?,emailid=?"+ "where userid=?");
			ps.setString(1,user.getFirstname());
			ps.setString(2,user.getLastname());
			ps.setDate(3,new java.sql.Date(user.getDob().getTime()));
			ps.setString(4,user.getEmailid());
			ps.setInt(5,user.getUserid());
			
			ps.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public List<User> getAllUsers()
	{
		List<User> users = new ArrayList<User>();
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from users");
			while(rs.next())
			{
				User user = new User();
				user.setUserid(rs.getInt("userid"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setDob(rs.getDate("dob"));
				user.setEmailid(rs.getString("emailid"));
				users.add(user);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return users;
	}	
		
		public User getUserById(int userid)
		{
			User user = new User();
			try
			{
				PreparedStatement ps = con.prepareStatement("select * from users where userid=?");
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					
					user.setUserid(rs.getInt("userid"));
					user.setFirstname(rs.getString("firstname"));
					user.setLastname(rs.getString("lastname"));
					user.setDob(rs.getDate("dob"));
					user.setEmailid(rs.getString("emailid"));
					
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			return user;
	}
}
