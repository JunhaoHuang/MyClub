package com.MyClub.vo;

import java.sql.Date;

import com.MyClub.enums.StatusE;

public class SignUpInfo {
	private int id;
	private String ActivityID;
	private String UserID;
	private StatusE Status = StatusE.Pending;
	private String Experience;
	private String Comment;
	private Date Time;
	private String SelfEvaluation;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getActivityID() {
		return ActivityID;
	}
	public void setActivityID(String activityID) {
		ActivityID = activityID;
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
	public String getExperience() {
		return Experience;
	}
	public void setExperience(String experience) {
		Experience = experience;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
	public Date getTime() {
		return Time;
	}
	public void setTime(Date time) {
		Time = time;
	}
	public String getSelfEvaluation() {
		return SelfEvaluation;
	}
	public void setSelfEvaluation(String selfEvaluation) {
		SelfEvaluation = selfEvaluation;
	}
}
