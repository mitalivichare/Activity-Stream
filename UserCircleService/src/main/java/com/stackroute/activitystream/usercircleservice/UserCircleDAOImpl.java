package com.stackroute.activitystream.usercircleservice;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserCircleDAOImpl implements UserCircleDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	UserCircle userCircle;
	
	private static Logger logger=LoggerFactory.getLogger(UserCircleDAOImpl.class);
	
	public UserCircleDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	public boolean addUserToCircle(int circleId, String emailId) {
		// TODO Auto-generated method stub
		try
		{
			UserCircle userSubscription=getUserCircle(circleId, emailId);
			if(userSubscription == null)
			{
				userCircle.setCircleId(circleId);
				userCircle.setEmailId(emailId);
				userCircle.setSubscriptionDate();
				userCircle.setSubscriptionStatus("A");
				sessionFactory.getCurrentSession().save(userCircle);
				logger.debug("User Added to Circle Successfully");
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			logger.debug("Adding user to Circle Failed");
			return false;
		}

	}

	public boolean removeUserFromCircle(int circleId, String emailId) {
		// TODO Auto-generated method stub
		try
		{
			userCircle=getUserCircle(circleId, emailId);
			if(userCircle != null)
			{
				userCircle.setSubscriptionStatus("N");
				logger.debug("Removing User From Circle Successfull in DAO");
				sessionFactory.getCurrentSession().update(userCircle);
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			logger.debug("Removing User From Circle Failed in DAO");
			return false;
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	private UserCircle getUserCircle(int circleId,String emailId)
	{
		try
		{
		Query query=sessionFactory.getCurrentSession().createQuery("from UserCircle where circleId=? and emailId=? and subscriptionStatus=?");
		query.setParameter(0, circleId);
		query.setParameter(1, emailId);
		query.setParameter(2, "A");
		UserCircle userCircle=(UserCircle) query.uniqueResult();
		return userCircle;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	

}
