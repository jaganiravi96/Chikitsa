package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.User;
import util.DbTranscation;

public class Resource {
	Connection conn = DbTranscation.getConnection();
	
	// get single user detail
	public User getUser(String id)
	{
		User u = null;
		try 
		{
			String sql = "select * from basic_detail where Aadhar_ID = ?";
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, id);
			ResultSet rt = pr.executeQuery();
			if(rt.next())
			{
				u = new User(rt.getString(1), rt.getString(2), rt.getString(3), rt.getString(4), rt.getString(5));
			}
			conn.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return u;
	}
	
	//login check
	public User userlogin(User u)
	{
		try 
		{
			String sql = "select * from basic_detail where Aadhar_ID = ? or contact = ? and password = ?";
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, u.getAadhar());
			pr.setString(2, u.getContact());
			pr.setString(3, u.getPassword());
			ResultSet rt = pr.executeQuery();
			if(rt.next())
			{
				u = new User(rt.getString(1), rt.getString(2), rt.getString(3), rt.getString(4), rt.getString(5));
			}
			conn.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return u;
	}
	
	// get all user detail
	public ArrayList<User> getall(String id)
	{
		ArrayList<User> list = new ArrayList<>();
		try 
		{
			String sql = "select * from basic_detail";
			Statement st = conn.createStatement();
			ResultSet rt = st.executeQuery(sql);
			while(rt.next())
			{
				User u = new User(rt.getString(1), rt.getString(2), rt.getString(3), rt.getString(4), rt.getString(5));
				list.add(u);
			}
			conn.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return list;
	}

	// create new user
	public String createUser(User u)
	{
		String sql = "insert into basic_detail (Aadhar_ID, Password, Name, Contact, usertype) VALUES (?, ?, ?, ?, ?)";
		try 
		{
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, u.getAadhar());
			pr.setString(2, u.getPassword());
			pr.setString(3, u.getName());
			pr.setString(4, u.getContact());
			pr.setString(5, u.getUsertype());
			 
			int a = pr.executeUpdate();
			conn.close();
		}  
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return u.getName();
	}
	
	// delete user
	public void deleteuser(String id)
	{
		try 
		{
			String sql = "delete from basic_detail where Aadhar_ID = ?";
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, id);
			pr.executeQuery();
			conn.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	// update user detail
	public void updateuser(String id, User u)
	{
		try 
		{
			String sql = "update basic_detail SET name = ?, contact = ? where Aadhar_ID = ?";
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(4, u.getAadhar());
			pr.setString(1, u.getName());
			pr.setString(2, u.getContact());
			pr.setString(3, u.getPassword());
			pr.executeQuery();	
			conn.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
