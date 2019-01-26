package service.dao;

import java.util.ArrayList;

import model.Appointment;
import model.Appointment_Status;

public interface AppointmentDao {
	
	public String generateId();
	public String createAppointment(Appointment a);
	public ArrayList<Appointment> getAllAppointment();
	public ArrayList<Appointment_Status> getAppointmentStatus();
	public Boolean manageAppointment(ArrayList<String> list, String btn);
	public int assigne_Doctor(String task_id);
}
