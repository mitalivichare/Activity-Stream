package com.stackroute.activitystream.userservice;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component //to tell spring 	about bean creation
@Entity //to tell hibernate about the table creation
public class User 
{

	//@Column(name="EMAIL_ID")
	@Id
	//@Email
	@JsonProperty(value="email_id")
	private String emailId;
	
	
	//@Column(name="FIRST_NAME")
	//@NotNull
	@JsonProperty(value="first_name")
	private String firstName;
	
	
	//@Column(name="LAST_NAME")
	//@NotNull
	@JsonProperty(value="last_name")
	private String lastName;
	
	//@Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
	
	
	//@Column(name="PASSWORD")
	//@NotNull
	private String password;
	
	//@Column(name="CONTACT_NUMBER")
	//@Pattern(regexp="^\\d(10)")
	@JsonProperty(value="contact_number")
	private String contactNumber;
	
	
	//@Column(name="USER_STATUS")
	//@NotNull
	@JsonProperty(value="user_status")
	private String userStatus;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", password="
				+ password + ", contactNumber=" + contactNumber + ", userStatus=" + userStatus + "]";
	}
	
	
	
	
}
