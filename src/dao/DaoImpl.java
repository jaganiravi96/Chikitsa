package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Appointment;
import model.User;
import util.DbTranscation;

public class DaoImpl implements Dao{
	Connection conn = DbTranscation.getConnection();

	// login check
	public User userLogin(User u) 
	{
		try {
			String sql = "select * from basic_detail where password = ? and (Aadhar_ID = ? or contact = ?)";
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, u.getPassword());
			pr.setString(2, u.getAadhar());
			pr.setString(3, u.getContact());
			ResultSet rt = pr.executeQuery();
			if(rt.next()) {
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
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

		return u.getName();
	}

	// create new id
	public String generateId()
	{
		String lastid = null;
		String sql = "SELECT task_id FROM task_manager ORDER BY task_id DESC";
		Statement st;
		try 
		{
			st = conn.createStatement();
			ResultSet rt = st.executeQuery(sql);
			if(rt.next()) 
			{
				lastid = rt.getString(1);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		System.out.println(lastid);
		if(lastid != null)
		{
			String id = "CHK0" + (Integer.parseInt(lastid.substring(4, lastid.length())) + 1);
			return id;
		} 
		else
		{
			return "CHK01";
		}

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
		String sql = "insert into ticket (Patient_Aadhar_ID, task_id, illeness_type, symptoms, duration, medication, Medical_History, Generic_History, severity) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
		String sql1 = "insert into task_manager (task_id) VALUES (?)";
		
		try {
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, a.getAadhar());
			pr.setString(2, a.getTaskid());
			pr.setString(3, a.getIllness());
			pr.setString(4, a.getSymptoms());
			pr.setString(5, a.getDuration());
			pr.setString(6, a.getMedication());
			pr.setString(7, a.getmHistory());
			pr.setString(8, a.getgHistory());
			pr.setString(9, a.getSeverity());
			int flag = pr.executeUpdate();
			
			PreparedStatement pr1 = conn.prepareStatement(sql1);
			pr1.setString(1, a.getTaskid());
			int flag1 = pr1.executeUpdate();
			
			//conn.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

		return a.getTaskid();
	}
	// get all ticket detail
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
						rt.getString(5), rt.getString(6), rt.getString(7), rt.getString(8), rt.getString(9));
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

	// get all ticket detail
	public ArrayList<Appointment> getAllAppointmentStatus() 
	{
		ArrayList<Appointment> list = new ArrayList<>();
		try 
		{
			String sql = "select * from task_manager";
			Statement st = conn.createStatement();
			ResultSet rt = st.executeQuery(sql);
			while (rt.next()) 
			{
				Appointment a = new Appointment(rt.getString(1), rt.getString(2), rt.getString(3), rt.getString(4),
						rt.getString(5), rt.getString(6), rt.getString(7), rt.getString(8), rt.getString(9));
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
					System.out.println(list.get(j));
					String sql = "delete from ticket where Patient_Aadhar_ID = ?";
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

	@Override
	public int assigne_Doctor(String task_id){
		int i = 0;
		String doctor_id = "";
		String sql = "SELECT Aadhar_Id FROM basic_detail WHERE usertype = 'Doctor' AND STATUS = 'available' AND aadhar_id NOT IN(SELECT DISTINCT(Assignee_DoctorId) FROM task_manager WHERE Assignee_DoctorId IS NOT NULL) ORDER BY Experience DESC";
		try{
			Statement st = conn.createStatement();
			ResultSet rt = st.executeQuery(sql);
			//if false then check for less ticket doctor
			if(rt.next() == false) 
			{ 
				String sql1 = "SELECT Assignee_DoctorId FROM (SELECT COUNT(Assignee_DoctorId) AS ticket_no, Assignee_DoctorId FROM task_manager WHERE Assignee_DoctorId IS NOT NULL GROUP BY Assignee_DoctorId ORDER BY ticket_no ASC)AS table1";
				Statement st1 = conn.createStatement();
				ResultSet rt1 = st1.executeQuery(sql1);
				if(rt1.next())
				{
					doctor_id = rt1.getString(1);
				} 
			} 
			else
			{ 
				doctor_id = rt.getString(1);
			}
			
			String sql2 = "update task_manager set Assignee_DoctorId=?, status=? where task_id=?";
			PreparedStatement pr = conn.prepareStatement(sql2);
			pr.setString(1, doctor_id);
			pr.setString(2, "Assigned");
			pr.setString(3, task_id);
			i = pr.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return i;
	}

}