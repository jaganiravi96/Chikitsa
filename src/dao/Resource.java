package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Appointment;
import model.User;
import util.DbTranscation;

public class Resource {
	Connection conn = DbTranscation.getConnection();

	// login check
	public User userLogin(User u) 
	{
		try {
			String sql = "select * from basic_detail where Aadhar_ID = ? or contact = ? and password = ?";
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, u.getAadhar());
			pr.setString(2, u.getContact());
			pr.setString(3, u.getPassword());
			ResultSet rt = pr.executeQuery();
			if (rt.next()) {
				u = new User(rt.getString(1), rt.getString(2), rt.getString(3), rt.getString(4), rt.getString(5),
						rt.getString(6), rt.getString(7), rt.getString(8));
			}
			conn.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return u;
	}

	// get single user detail
	public User getUser(String id) {
		User u = null;
		try {
			String sql = "select * from basic_detail where Aadhar_ID = ?";
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, id);
			ResultSet rt = pr.executeQuery();
			if (rt.next()) {
				u = new User(rt.getString(1), rt.getString(2), rt.getString(3), rt.getString(4), rt.getString(5),
						rt.getString(6), rt.getString(7), rt.getString(8));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return u;
	}

	// get all user detail
	public ArrayList<User> getAllUser() {
		ArrayList<User> list = new ArrayList<>();
		try {
			String sql = "select * from basic_detail where usertype != 'Nodel'";
			Statement st = conn.createStatement();
			ResultSet rt = st.executeQuery(sql);
			while (rt.next()) {
				User u = new User(rt.getString(1), rt.getString(2), rt.getString(3), rt.getString(4), rt.getString(5),
						rt.getString(6), rt.getString(7), rt.getString(8));
				list.add(u);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// create new user
	public String createUser(User u) {
		String sql = "insert into basic_detail (Aadhar_ID, Password, Name, Contact, usertype) VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, u.getAadhar());
			pr.setString(2, u.getPassword());
			pr.setString(3, u.getName());
			pr.setString(4, u.getContact());
			pr.setString(5, u.getUsertype());

			int a = pr.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return u.getName();
	}

	// create new id
	public String getId() throws SQLException {
		String lastid = "";
		String sql = "SELECT task_id FROM ticket ORDER BY task_id DESC";
		Statement st = conn.createStatement();
		ResultSet rt = st.executeQuery(sql);
		if (rt.next()) {
			lastid = rt.getString(1);
		}

		String id = "CHK0" + (Integer.parseInt(lastid.substring(4, lastid.length())) + 1);

		return id;
	}

	// delete user
	public void deleteUser(String id) {
		try {
			String sql = "delete from basic_detail where Aadhar_ID = ?";
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, id);
			pr.executeQuery();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// update user detail
	public void updateUser(String id, User u) {
		try {
			String sql = "update basic_detail SET name = ?, contact = ? where Aadhar_ID = ?";
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(4, u.getAadhar());
			pr.setString(1, u.getName());
			pr.setString(2, u.getContact());
			pr.setString(3, u.getPassword());
			pr.executeQuery();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// create new appointment
	public String createAppointment(Appointment a) {
		String sql = "insert into ticket (Patient_Aadhar_ID,illeness_type, symptoms, duration, medication, Medical_History, Generic_History, severity) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, a.getAadhar());
			pr.setString(2, a.getIllness());
			pr.setString(3, a.getSymptoms());
			pr.setString(4, a.getDuration());
			pr.setString(5, a.getMedication());
			pr.setString(6, a.getmHistory());
			pr.setString(7, a.getgHistory());
			pr.setString(8, a.getSeverity());

			int flag = pr.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "";
	}

	// get all user detail
	public ArrayList<Appointment> getAllAppointment() 
	{
		ArrayList<Appointment> list = new ArrayList<>();
		try 
		{
			String sql = "select * from ticket";
			Statement st = conn.createStatement();
			ResultSet rt = st.executeQuery(sql);
			while (rt.next()) 
			{
				Appointment a = new Appointment(rt.getString(1), rt.getString(2), rt.getString(3), rt.getString(4),
						rt.getString(5), rt.getString(6), rt.getString(7), rt.getString(8));
				list.add(a);
			}
			conn.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return list;
	}
	
	public Boolean manageAppointment(ArrayList<String> list, String btn) 
	{
		boolean a = false;
		if(btn.equals("Update"))
		{
			try 
			{
				String sql = "update basic_detail SET name = ?, contact = ? where Aadhar_ID = ?";
				PreparedStatement pr = conn.prepareStatement(sql);
				/*pr.setString(4, u.getAadhar());
				pr.setString(1, u.getName());
				pr.setString(2, u.getContact());
				pr.setString(3, u.getPassword());*/
				a = pr.execute();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		else if(btn.equals("Delete")) 
		{
			for(int j=0;j<list.size();j++)
			{
				try 
				{
					String sql = "delete from ticket where Doctor_Aadhar_ID = ?";
					PreparedStatement pr = conn.prepareStatement(sql);
					pr.setString(1, list.get(j));
					a = pr.execute();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
		return a;
	}
}
