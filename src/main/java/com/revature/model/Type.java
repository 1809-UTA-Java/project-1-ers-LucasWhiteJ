package com.revature.model;

public class Type {
	private int rtID;
	private String rType;

	public int getRtID() {
		return rtID;
	}

	public void setRtID(int rtID) {
		this.rtID = rtID;
	}

	public String getrType() {
		return rType;
	}

	public void setrType(String rType) {
		this.rType = rType;
	}

	public Type(int rtID, String rType) {
		super();
		this.rtID = rtID;
		this.rType = rType;
	}

	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Type [rtID=" + rtID + ", rType=" + rType + "]";
	}
}
