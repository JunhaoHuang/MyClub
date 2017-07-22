package com.MyClub.vo;

import java.sql.Date;

import com.MyClub.enums.FType;

public class ClubFeesInfo {
	private int id;
	private String ClubID;
	private String UserID;
	private float Fees;
	private Date Time;
	private FType FeesType;
	private String Remarks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClubID() {
		return ClubID;
	}

	public void setClubID(String clubID) {
		ClubID = clubID;
	}

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public float getFees() {
		return Fees;
	}

	public void setFees(float fees) {
		Fees = fees;
	}

	public Date getTime() {
		return Time;
	}

	public void setTime(Date time) {
		Time = time;
	}

	public String getFeesType() {
		return FeesType.toString();
	}

	public void setFeesType(String s) {
		switch (s) {
		case "Income":
			FeesType = FType.Income;
			break;
		case "Expense":
			FeesType = FType.Expense;
			break;
		}
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
}
