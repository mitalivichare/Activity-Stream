package com.stackroute.activitystream.usercircleservice;

public interface UserCircleDAO 
{
	public boolean addUserToCircle(int circleId,String emailId);
	public boolean removeUserFromCircle(int circleId,String emailId);

}
