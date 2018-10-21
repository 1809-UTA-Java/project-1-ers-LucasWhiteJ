package com.revature.model;

public class Position {
	private int positionID;
	private String position;

	public int getPositionID() {
		return positionID;
	}

	public void setPositionID(int positionID) {
		this.positionID = positionID;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Position(int positionID, String position) {
		super();
		this.positionID = positionID;
		this.position = position;
	}

	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Position [positionID=" + positionID + ", position=" + position + "]";
	}
}
