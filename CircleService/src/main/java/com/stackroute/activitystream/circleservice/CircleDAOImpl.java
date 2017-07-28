package com.stackroute.activitystream.circleservice;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("circleDAO")
@Transactional
public class CircleDAOImpl implements CircleDAO
{
	
	@Autowired
	SessionFactory sessionFactory;
	
	private static Logger logger=LoggerFactory.getLogger(CircleDAOImpl.class);
	
	public CircleDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	
	public boolean createCircle(Circle circle)
	{
		try
		{
			circle.setCircleCreationDate();
			circle.setCircleStatus("A");
			sessionFactory.getCurrentSession().save(circle);
			logger.debug("Circle Creation Successfull in DAO");
			return true;
		}
		catch(Exception e)
		{
			logger.debug("Circle creation Failed in DAO");
			return false;
		}
	}
	
	public boolean updateCircle(Circle circle)
	{
		try
		{
			sessionFactory.getCurrentSession().update(circle);
			logger.debug("Circle Updation Successfull in DAO");
			return true;
		}
		catch(Exception e)
		{
			logger.debug("Circle Updation Failed in DAO");
			return false;
		}
	}
	
	public boolean deleteCircle(int circleId)
	{
		try
		{
			Circle deleteCircle=getCircleByCircleId(circleId);
			if(deleteCircle != null)
			{
			deleteCircle.setCircleStatus("N");
			sessionFactory.getCurrentSession().update(deleteCircle);
			logger.debug("Deleting User Successfull in DAO");
			return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			logger.debug("Deleting User UnSuccessfull in DAO");
			return false;
		}
	}
	
	/*private Circle getCircleDetails(int circleId)
	{
		try
		{
		Circle circle=sessionFactory.getCurrentSession().get(Circle.class, circleId);
		logger.debug("Fetching Circle Details Successfull");
		return circle;
		}
		catch(Exception e)
		{
			logger.debug("Fetching Circle details failed");
			return null;
		}
	}*/
	
	public Circle getCircleByCircleId(int circleId)
	{
		try
		{
			Circle circle= sessionFactory.getCurrentSession().get(Circle.class,circleId);
			logger.debug("Fetching circle details by ID Successfull in DAO");
			return circle;
		}
		catch(Exception e)
		{
			logger.debug("Fetching circle details by ID UnSuccessfull in DAO");
			return null;
		}
	}
	
	public Circle getCircleByCircleName(String circleName)
	{
		try
		{
			Query query=sessionFactory.getCurrentSession().createQuery("from Circle where circleName=?");
			query.setParameter(0, circleName);
			Circle circle=(Circle) query.uniqueResult();
			logger.debug("Fetching circle details by Circle Name Successfull in DAO");
			return circle;
		}
		catch(Exception e)
		{
			logger.debug("Fetching Circle Details by Name UnSuccessfull in DAO");
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Circle> getAllCircles()
	{
		try
		{
			List<Circle> circleList=sessionFactory.getCurrentSession().createQuery("from Circle").list();
			logger.debug("Fetching list of circles Successfull in DAO");
			return circleList;
		}
		catch(Exception e)
		{
			logger.debug("Fetching List of circles Failed in DAO");
			return null;
		}
	}

}
