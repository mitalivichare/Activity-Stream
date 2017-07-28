package com.stackroute.activitystream.userservice;

import java.util.List;

public interface UserDAO 
{
	public boolean createUser(User user);
	public boolean updateUser(User user);
	public User authenticateUser(User user);
	public boolean deleteUser(String emailId);
	public User getUserByUserId(String emailId);
	public List<User> getAllUsers();
	

}
