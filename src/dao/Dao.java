package dao;

import java.util.ArrayList;

import model.Appointment;
import model.Appointment_Status;
import model.User;

public interface Dao {
	
	public User userLogin(User u);
	public String createAppointment(Appointment a);
	public String createUser(User u);
	public void deleteUser(String id);
	public ArrayList<Appointment> getAllAppointment();
	public ArrayList<Appointment_Status> getAppointmentStatus();
	public ArrayList<User> getAllUser();
	public String generateId();
	public User getUser(String id);
	public Boolean manageAppointment(ArrayList<String> list, String btn);
	public void updateUser(String id, User u);
	public int assigne_Doctor(String task_id);

}
