package com.stackroute.activitystream.usercircleservice;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class UserCircle 
{
	@Id
	private int userCircleId;
	
	//@NotNull
	private String emailId;
	//@NotNull
	private int circleId;
	//@NotNull
	private Date subscriptionDate;
	
	//@NotNull
	private String subscriptionStatus;
	
	
	public int getUserCircleId() {
		return userCircleId;
	}
	public void setUserCircleId(int userCircleId) {
		this.userCircleId = userCircleId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getCircleId() {
		return circleId;
	}
	public void setCircleId(int circleId) {
		this.circleId = circleId;
	}
	public Date getSubscriptionDate() {
		return subscriptionDate;
	}
	public void setSubscriptionDate() {
		this.subscriptionDate = new Date();
	}
	public String getSubscriptionStatus() {
		return subscriptionStatus;
	}
	public void setSubscriptionStatus(String subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}
	@Override
	public String toString() {
		return "UserCircle [userCircleId=" + userCircleId + ", emailId=" + emailId + ", circleId=" + circleId
				+ ", subscriptionDate=" + subscriptionDate + ", subscriptionStatus=" + subscriptionStatus + "]";
	}
	
	
	

}
