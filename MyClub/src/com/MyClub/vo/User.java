package com.MyClub.vo;

import com.MyClub.enums.SexE;

public class User {
	private String UserID;
	private String UserName;
	private SexE Sex;
	private String PhoneNumber;
	private String School;
	private String StudentID;
	private String Name;
	private String HeadPicture;

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getSex() {
		return Sex.toString();
	}

	public void setSex(String s) {
		switch (s) {
		case "Male":
			Sex = SexE.Male;
			break;
		case "Female":
			Sex = SexE.Female;
			break;
		}
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getSchool() {
		return School;
	}

	public void setSchool(String school) {
		School = school;
	}

	public String getStudentID() {
		return StudentID;
	}

	public void setStudentID(String studentID) {
		StudentID = studentID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getHeadPicture() {
		return HeadPicture;
	}

	public void setHeadPicture(String headPicture) {
		HeadPicture = headPicture;
	}
}
