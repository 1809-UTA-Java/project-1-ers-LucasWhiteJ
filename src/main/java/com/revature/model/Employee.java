package com.revature.model;

public class Employee {
	private int eid;
	private String eUserName;
	private String ePassword;
	private String eFirstName;
	private String eLastName;
	private String email;
	private int positionid;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String geteUserName() {
		return eUserName;
	}

	public void seteUserName(String eUserName) {
		this.eUserName = eUserName;
	}

	public String getePassword() {
		return ePassword;
	}

	public void setePassword(String ePassword) {
		this.ePassword = ePassword;
	}

	public String geteFirstName() {
		return eFirstName;
	}

	public void seteFirstName(String eFirstName) {
		this.eFirstName = eFirstName;
	}

	public String geteLastName() {
		return eLastName;
	}

	public void seteLastName(String eLastName) {
		this.eLastName = eLastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPositionid() {
		return positionid;
	}

	public void setPositionid(int positionid) {
		this.positionid = positionid;
	}

	public Employee(int eid, String eUserName, String ePassword, String eFirstName, String eLastName, String email,
			int positionid) {
		super();
		this.eid = eid;
		this.eUserName = eUserName;
		this.ePassword = ePassword;
		this.eFirstName = eFirstName;
		this.eLastName = eLastName;
		this.email = email;
		this.positionid = positionid;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", eUserName=" + eUserName + ", ePassword=" + ePassword + ", eFirstName="
				+ eFirstName + ", eLastName=" + eLastName + ", email=" + email + ", positionid=" + positionid + "]";
	}

}
