package com.revature.model;

public class Status {
	private int rsID;
	private String rStatus;

	public int getRsID() {
		return rsID;
	}

	public void setRsID(int rsID) {
		this.rsID = rsID;
	}

	public String getrStatus() {
		return rStatus;
	}

	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}

	@Override
	public String toString() {
		return "Status [rsID=" + rsID + ", rStatus=" + rStatus + "]";
	}

	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Status(int rsID, String rStatus) {
		super();
		this.rsID = rsID;
		this.rStatus = rStatus;
	}
}
