package com.revature.model;

import java.sql.Timestamp;

public class Reimbursements {
	private int rID;
	private double ramount;
	private String rDescription;
	// private rReceipt;
	private Timestamp rSubmitted;
	private Timestamp rResolved;
	private int uIDAuthor;
	private int uIDResolver;
	private int rType;
	private int rStatus;

	public Reimbursements() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursements(int rID, double ramount, String rDescription, Timestamp rSubmitted, Timestamp rResolved,
			int uIDAuthor, int uIDResolver, int rType, int rStatus) {
		super();
		this.rID = rID;
		this.ramount = ramount;
		this.rDescription = rDescription;
		this.rSubmitted = rSubmitted;
		this.rResolved = rResolved;
		this.uIDAuthor = uIDAuthor;
		this.uIDResolver = uIDResolver;
		this.rType = rType;
		this.rStatus = rStatus;
	}

	public int getrID() {
		return rID;
	}

	public void setrID(int rID) {
		this.rID = rID;
	}

	public double getRamount() {
		return ramount;
	}

	public void setRamount(double ramount) {
		this.ramount = ramount;
	}

	public String getrDescription() {
		return rDescription;
	}

	public void setrDescription(String rDescription) {
		this.rDescription = rDescription;
	}

	public Timestamp getrSubmitted() {
		return rSubmitted;
	}

	public void setrSubmitted(Timestamp rSubmitted) {
		this.rSubmitted = rSubmitted;
	}

	public Timestamp getrResolved() {
		return rResolved;
	}

	public void setrResolved(Timestamp rResolved) {
		this.rResolved = rResolved;
	}

	public int getuIDAuthor() {
		return uIDAuthor;
	}

	public void setuIDAuthor(int uIDAuthor) {
		this.uIDAuthor = uIDAuthor;
	}

	public int getuIDResolver() {
		return uIDResolver;
	}

	public void setuIDResolver(int uIDResolver) {
		this.uIDResolver = uIDResolver;
	}

	public int getrType() {
		return rType;
	}

	public void setrType(int rType) {
		this.rType = rType;
	}

	public int getrStatus() {
		return rStatus;
	}

	public void setrStatus(int rStatus) {
		this.rStatus = rStatus;
	}

	@Override
	public String toString() {
		return "Reimbursements [rID=" + rID + ", ramount=" + ramount + ", rDescription=" + rDescription
				+ ", rSubmitted=" + rSubmitted + ", rResolved=" + rResolved + ", uIDAuthor=" + uIDAuthor
				+ ", uIDResolver=" + uIDResolver + ", rType=" + rType + ", rStatus=" + rStatus + "]";
	}

}
