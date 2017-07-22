package com.MyClub.vo;

import com.MyClub.enums.UType;

public class Admin {
	private String UserID;
	private String AccountNum;
	private String Password;
	private UType UserType = UType.Admin;

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getAccountNum() {
		return AccountNum;
	}

	public void setAccountNum(String accountNum) {
		AccountNum = accountNum;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getUserType() {
		return UserType.toString();
	}

	public void setUserType(String s) {
		switch (s) {
		case "Admin":
			UserType = UType.Admin;
			break;
		case "User":
			UserType = UType.User;
			break;
		}
	}
}
