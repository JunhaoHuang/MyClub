package com.MyClub.vo;

import java.sql.Date;

import com.MyClub.enums.PStatusE;
import com.MyClub.enums.PositionE;
import com.MyClub.enums.StatusE;

public class ClubMemberInfo {
	private int id;
	private String ClubID;
	private String UserID;
	private StatusE Status = StatusE.Pending;
	private PStatusE PayStatus = PStatusE.NoFees;
	private PositionE Position = PositionE.Member;
	private Date JoinDate;

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

	public String getStatus() {
		return Status.toString();
	}

	public void setStatus(String s) {
		switch (s) {
		case "Pending":
			Status = StatusE.Pending;
			break;
		case "Pass":
			Status = StatusE.Pass;
			break;
		case "Fail":
			Status = StatusE.Fail;
			break;
		}
	}

	public String getPayStatus() {
		return PayStatus.toString();
	}

	public void setPayStatus(String s) {
		switch (s) {
		case "NotPaid":
			PayStatus = PStatusE.NotPaid;
			break;
		case "Paid":
			PayStatus = PStatusE.Paid;
			break;
		case "NoFees":
			PayStatus = PStatusE.NoFees;
			break;
		}
	}

	public String getPosition() {
		return Position.toString();
	}

	public void setPosition(String s) {
		switch (s) {
		case "President":
			Position = PositionE.President;
			break;
		case "VicePresident":
			Position = PositionE.VicePresident;
			break;
		case "Minister":
			Position = PositionE.Minister;
			break;
		case "ViceMinister":
			Position = PositionE.ViceMinister;
			break;
		case "Member":
			Position = PositionE.Member;
			break;
		}
	}

	public Date getJoinDate() {
		return JoinDate;
	}

	public void setJoinDate(Date joinDate) {
		JoinDate = joinDate;
	}
}
