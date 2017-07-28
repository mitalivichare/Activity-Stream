package com.stackroute.activitystream.circleservice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircleController 
{
	@Autowired
	CircleDAO circleDAO;
	
	@Autowired
	HttpSession session;
	
	Logger logger=LoggerFactory.getLogger(CircleController.class);
	
	@RequestMapping(value="/createcircle",method=RequestMethod.POST)
	public ResponseEntity<?> createCircle(@RequestBody Circle circle)
	{
		try
		{
		circleDAO.createCircle(circle);
		logger.debug("Circle Creation Successull");
		return new ResponseEntity<Circle>(circle,HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.debug("Circle Creation Failed");;
			return new ResponseEntity<Void>(HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	@RequestMapping(value="/updatecircle",method=RequestMethod.POST)
	public ResponseEntity<?> updateCircle(@RequestBody Circle circle)
	{
		try
		{
			circleDAO.updateCircle(circle);
			logger.debug("Updating Circle Sucessfull");
			return new ResponseEntity<Circle>(circle,HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.debug("Updating Circle Failed");
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/deletecircle",method=RequestMethod.POST)
	public ResponseEntity<?> deleteCircle(@RequestBody int circleId)
	{
		try
		{
			circleDAO.deleteCircle(circleId);
			logger.debug("De-Activating Circle Sucessfull");
			return new ResponseEntity<Integer>(circleId,HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.debug("De-Activating Circle Failed");
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/getallcircles",method=RequestMethod.GET)
	public ResponseEntity<?> getAllCircles()
	{
		try
		{
			List<Circle> circleList=circleDAO.getAllCircles();
			logger.debug("Fetching list of circles Successfull");
			return new ResponseEntity<List<Circle>>(circleList,HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.debug("Fetching list of circles Failed");
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}

}
