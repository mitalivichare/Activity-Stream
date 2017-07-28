package com.stackroute.activitystream.userservice;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO
{
	private static Logger logger=LoggerFactory.getLogger(UserDAOImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	//Method to create new User
	public boolean createUser(User user)
	{
		try
		{
			user.setUserStatus("A");
			sessionFactory.getCurrentSession().save(user);
			logger.debug("Registration sucessfull in DAO");
			return true;
		}
		catch(Exception e)
		{
			logger.debug("Registration Failed in DAO..");
			return  false;
		}
	}
	
	//Method to Update details of existing User
	public boolean updateUser(User user)
	{
		try
		{
			sessionFactory.getCurrentSession().update(user);
			logger.debug("User Details Updated Successfully..");
			return true;
		}
		catch(Exception e)
		{
			logger.debug("Unable to Update User Details..");
			return false;
		}
	}

	//Method to Authenticate the User
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public User authenticateUser(User user) {
		// TODO Auto-generated method stub
		try
		{
			Query query=sessionFactory.getCurrentSession().createQuery("from User where emailId=? and password=?");
			query.setParameter(0,user.getEmailId());
			query.setParameter(1, user.getPassword());
			User newUser=(User) query.uniqueResult();
			logger.debug("Login Sucessfull");
			return newUser;
		}
		catch(Exception e)
		{
			logger.debug("Login Failed");
		return null;
		}
	}
	
	//Method to de-activate User Account
	public boolean deleteUser(String emailId)
	{
		try
		{
			User user=getUserByUserId(emailId);
			user.setUserStatus("N");
			sessionFactory.getCurrentSession().update(user.getEmailId(),user);
			logger.debug("De-Activating User Account Successfull");
			return true;
		}
		catch(Exception e)
		{
			logger.debug("De-Activiting User Account Failed");
			return false;
		}
	}
	
	//Method to fetch details of an User by ID
	public User getUserByUserId(String emailId)
	{
		try
		{
		User user=sessionFactory.getCurrentSession().get(User.class, emailId);
		logger.debug("Fetching user details Successfull");
		return user;
		}
		catch(Exception e)
		{
			logger.debug("Fetching user details failed");
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers()
	{
		try
		{
			List<User> user=sessionFactory.getCurrentSession().createQuery("from User").list();
			return user;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	

}
