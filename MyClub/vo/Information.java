package com.MyClub.vo;

import java.sql.Date;

import com.MyClub.enums.IType;

public class Information {
	private int InforID;
	private String UserID;
	private String SourceID;
	private String InfoContent;
	private Date Time;
	private IType InfoType = IType.Admin;
	
	
	public int getInforID() {
		return InforID;
	}
	public void setInforID(int inforID) {
		InforID = inforID;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getSourceID() {
		return SourceID;
	}
	public void setSourceID(String sourceID) {
		SourceID = sourceID;
	}
	public String getInfoContent() {
		return InfoContent;
	}
	public void setInfoContent(String infoContent) {
		InfoContent = infoContent;
	}
	public Date getTime() {
		return Time;
	}
	public void setTime(Date time) {
		Time = time;
	}
	public String getInfoType() {
		return InfoType.toString();
	}
	public void setInfoType(String s) {
		switch(s){
		case "Club":
			InfoType = IType.Club;
			break;
		case "Activity":
			InfoType = IType.Activity;
			break;
		case "Admin":
			InfoType = IType.Admin;
			break;
		}
	}
}
