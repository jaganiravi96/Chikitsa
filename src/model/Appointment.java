package model;

public class Appointment {
	private String aadhar;
	private String illness;
	private String symptoms;
	private String duration;
	private String medication;
	private String mHistory;
	private String gHistory;
	private String severity;
	
	public Appointment() {
		super();
	}
	
	public Appointment(String aadhar, String illness, String symptoms, String duration, String medication,
			String mHistory, String gHistory, String severity) {
		super();
		this.aadhar = aadhar;
		this.illness = illness;
		this.symptoms = symptoms;
		this.duration = duration;
		this.medication = medication;
		this.mHistory = mHistory;
		this.gHistory = gHistory;
		this.severity = severity;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getIllness() {
		return illness;
	}

	public void setIllness(String illness) {
		this.illness = illness;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getMedication() {
		return medication;
	}

	public void setMedication(String medication) {
		this.medication = medication;
	}

	public String getmHistory() {
		return mHistory;
	}

	public void setmHistory(String mHistory) {
		this.mHistory = mHistory;
	}

	public String getgHistory() {
		return gHistory;
	}

	public void setgHistory(String gHistory) {
		this.gHistory = gHistory;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}
	
}
