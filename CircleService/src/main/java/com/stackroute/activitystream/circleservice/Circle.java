package com.stackroute.activitystream.circleservice;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Circle 
{
	@Id
	private int circleId;
	
	//@NotNull
	private String circleName;
	
	//@NotNull
	private String circleOwner;
	
	private String circleDescription;
	
	//@NotNull
	private Date circleCreationDate;
	
	//@NotNull
	private String circleStatus;
	
	public int getCircleId() {
		return circleId;
	}
	public void setCircleId(int circleId) {
		this.circleId = circleId;
	}
	public String getCircleOwner() {
		return circleOwner;
	}
	public void setCircleOwner(String circleOwner) {
		this.circleOwner = circleOwner;
	}
	public String getCircleName() {
		return circleName;
	}
	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}
	public String getCircleDescription() {
		return circleDescription;
	}
	public void setCircleDescription(String circleDescription) {
		this.circleDescription = circleDescription;
	}
	public Date getCircleCreationDate() {
		return circleCreationDate;
	}
	public void setCircleCreationDate() {
		this.circleCreationDate = new Date();
	}
	
	public String getCircleStatus() {
		return circleStatus;
	}
	public void setCircleStatus(String circleStatus) {
		this.circleStatus = circleStatus;
	}
	@Override
	public String toString() {
		return "Circle [circleId=" + circleId + ", circleName=" + circleName + ", circleOwner=" + circleOwner
				+ ", circleDescription=" + circleDescription + ", circleCreationDate=" + circleCreationDate
				+ ", circleStatus=" + circleStatus + "]";
	}
	
	

}
