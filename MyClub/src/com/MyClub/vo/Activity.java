package com.MyClub.vo;

import java.sql.Date;

import com.MyClub.enums.AStatusE;
import com.MyClub.enums.CType;

public class Activity {
	private String ActivityID;
	private String ClubID;
	private String ActivityName;
	private CType ActivityType;
	private String Details;
	private AStatusE ActivityStatus = AStatusE.Operable;
	private String Location;
	private Date ActivityStartTime;
	private Date ActivityEndTime;
	private Date SignUpStartTime;
	private Date SignUpEndTime;
	private int LowerLimit;
	private int UpperLimit;
	private String ActivityLogo;

	public String getActivityID() {
		return ActivityID;
	}

	public void setActivityID(String activityID) {
		ActivityID = activityID;
	}

	public String getClubID() {
		return ClubID;
	}

	public void setClubID(String clubID) {
		ClubID = clubID;
	}

	public String getActivityName() {
		return ActivityName;
	}

	public void setActivityName(String activityName) {
		ActivityName = activityName;
	}

	public String getActivityType() {
		return ActivityType.toString();
	}

	public void setActivityType(String s) {
		switch (s) {
		case "Sport":
			ActivityType = CType.Sport;
			break;
		case "Art":
			ActivityType = CType.Art;
			break;
		case "Welfare":
			ActivityType = CType.Welfare;
			break;
		case "Science":
			ActivityType = CType.Science;
			break;
		case "Hobby":
			ActivityType = CType.Hobby;
			break;
		case "Other":
			ActivityType = CType.Other;
			break;
		}
	}

	public String getDetails() {
		return Details;
	}

	public void setDetails(String details) {
		Details = details;
	}

	public String getActivityStatus() {
		return ActivityStatus.toString();
	}

	public void setActivityStatus(String s) {
		switch(s){
		case "Operable":
			ActivityStatus = AStatusE.Operable;
			break;
		case "Inoperable":
			ActivityStatus = AStatusE.Inoperable;
			break;
		case "Overdue":
			ActivityStatus = AStatusE.Overdue;
			break;
		}
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public Date getActivityStartTime() {
		return ActivityStartTime;
	}

	public void setActivityStartTime(Date activityStartTime) {
		ActivityStartTime = activityStartTime;
	}

	public Date getActivityEndTime() {
		return ActivityEndTime;
	}

	public void setActivityEndTime(Date activityEndTime) {
		ActivityEndTime = activityEndTime;
	}

	public Date getSignUpStartTime() {
		return SignUpStartTime;
	}

	public void setSignUpStartTime(Date signUpStartTime) {
		SignUpStartTime = signUpStartTime;
	}

	public Date getSignUpEndTime() {
		return SignUpEndTime;
	}

	public void setSignUpEndTime(Date signUpEndTime) {
		SignUpEndTime = signUpEndTime;
	}

	public int getLowerLimit() {
		return LowerLimit;
	}

	public void setLowerLimit(int lowerLimit) {
		LowerLimit = lowerLimit;
	}

	public int getUpperLimit() {
		return UpperLimit;
	}

	public void setUpperLimit(int upperLimit) {
		UpperLimit = upperLimit;
	}

	public String getActivityLogo() {
		return ActivityLogo;
	}

	public void setActivityLogo(String activityLogo) {
		ActivityLogo = activityLogo;
	}
}
