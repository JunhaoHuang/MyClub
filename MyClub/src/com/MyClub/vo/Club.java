package com.MyClub.vo;

import java.sql.Date;

import com.MyClub.enums.StatusE;
import com.MyClub.enums.CType;

public class Club {
	private String ClubID;
	private String ClubName;
	private CType ClubType;
	private String School;
	private StatusE Status = StatusE.Pending;
	private Boolean FeesStatus;
	private Float PerFees;
	private Date CreateDate;
	private String About;
	private String ClubLogo;

	public String getClubID() {
		return ClubID;
	}

	public void setClubID(String clubID) {
		ClubID = clubID;
	}

	public String getClubName() {
		return ClubName;
	}

	public void setClubName(String clubName) {
		ClubName = clubName;
	}

	public String getClubType() {
		return ClubType.toString();
	}
	
	public String retClubType(){
		switch (ClubType) {
		case Sport:
			return "体育竞技";
		case Art:
			return "文化艺术";
		case Welfare:
			return "爱心公益";
		case Science:
			return "科技学术";
		case Hobby:
			return "兴趣爱好";
		case Other:
			return "其他";
		}
		return null;
	}
	
	public String retClubTypePic(){
		switch (ClubType) {
		case Sport:
			return "img/s.png";
		case Art:
			return "img/a.png";
		case Welfare:
			return "img/w.png";
		case Science:
			return "img/sc.png";
		case Hobby:
			return "img/h.png";
		case Other:
			return "img/o.png";
		}
		return null;
	}

	public void setClubType(String s) {
		switch (s) {
		case "Sport":
			ClubType = CType.Sport;
			break;
		case "Art":
			ClubType = CType.Art;
			break;
		case "Welfare":
			ClubType = CType.Welfare;
			break;
		case "Science":
			ClubType = CType.Science;
			break;
		case "Hobby":
			ClubType = CType.Hobby;
			break;
		case "Other":
			ClubType = CType.Other;
			break;
		}
	}

	public String getSchool() {
		return School;
	}

	public void setSchool(String school) {
		School = school;
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

	public Boolean getFeesStatus() {
		return FeesStatus;
	}

	public void setFeesStatus(Boolean feesStatus) {
		FeesStatus = feesStatus;
	}

	public Float getPerFees() {
		return PerFees;
	}

	public void setPerFees(Float perFees) {
		PerFees = perFees;
	}

	public Date getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}

	public String getAbout() {
		return About;
	}

	public void setAbout(String about) {
		About = about;
	}

	public String getClubLogo() {
		return ClubLogo;
	}

	public void setClubLogo(String clubLogo) {
		ClubLogo = clubLogo;
	}
}
