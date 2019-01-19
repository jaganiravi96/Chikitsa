package model;

public class User {

	private String aadhar;
	private String password;
	private String name;
	private String contact;
	private String usertype;
	private String empid;
	private String experience;
	private String status;
		
	public User() {
		super();
	}

	public User(String aadhar, String password, String name, String contact, String usertype, String empid,
			String experience, String status) {
		super();
		this.aadhar = aadhar;
		this.password = password;
		this.name = name;
		this.contact = contact;
		this.usertype = usertype;
		this.empid = empid;
		this.experience = experience;
		this.status = status;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
