package model;

import java.util.Date;

public class Appointment_Status {
	private String task_id;
	private String doctor_id;
	private String status;
	private Date registration_date;
	private Date resolved_date;
	private String Description;
	
	public Appointment_Status() {
		super();
	}
	
	public Appointment_Status(String task_id, String doctor_id, String status, Date registration_date, Date resolved_date,
			String description) {
		super();
		this.task_id = task_id;
		this.doctor_id = doctor_id;
		this.status = status;
		this.registration_date = registration_date;
		this.resolved_date = resolved_date;
		Description = description;
	}

	public String getTask_id() {
		return task_id;
	}

	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}

	public String getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(String doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}

	public Date getResolved_date() {
		return resolved_date;
	}

	public void setResolved_date(Date resolved_date) {
		this.resolved_date = resolved_date;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}	
}
