package com.stackroute.activitystream.circleservice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CircleServiceApplicationTests {
	
	@Autowired
	private static Circle circle;

	@Autowired
	private static CircleDAO circleDAO;

	@Autowired
	private static AnnotationConfigApplicationContext applicationContext;

	@BeforeClass
	public static void init() {
		applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.scan("com.stackroute.activitystream.backend");
		applicationContext.refresh();
		circle = applicationContext.getBean(Circle.class);
		circleDAO = (CircleDAO) applicationContext.getBean("circleDAO");
	}
	
	//@Test
	public void createCircleTest()
	{
		Circle circle=new Circle();
		circle.setCircleName("ReBoot");
		circle.setCircleOwner("lisa@gmail.com");
		circle.setCircleDescription("The Re-Boot gang");
		circle.setCircleCreationDate();
		assertEquals(true, circleDAO.createCircle(circle));
	}
	
	@Test
	public void updateCircle()
	{
		circle=circleDAO.getCircleByCircleId(2);
		circle.setCircleStatus("A");
		//circle.setCircleDescription("The Ghoooost Gang");
		assertEquals(true,circleDAO.updateCircle(circle));
	}
	
	/*@Test
	public void deleteCircle()
	{
		assertEquals("Circle Deleted Successfully", true, circleDAO.deleteCircle(2));
	}*/
	
	@Test
	public void getCircleByCircleId()
	{
		//assertEquals("Fetching Circle by ID Test Successfull", "ReBoot", circleDAO.getCircleByCircleId(2).getCircleName());
		circle=circleDAO.getCircleByCircleId(4);
		assertNotNull(circle);
		display("GetCircleByCircleId",circle);
	}
	
	@Test
	public void getCircleByCircleName()
	{
		circle=circleDAO.getCircleByCircleName("Boot");
		assertNotNull(circle);
		display("GetCircleByCircleName",circle);
	}
	
	@Test
	public void getAllCirclesTest()
	{
		List<Circle> circleList=circleDAO.getAllCircles();
		assertNotNull(circleList);
		System.out.println("List of Circles Available");
		System.out.println("========================================");
		for(Circle circle : circleList)
		{
			System.out.println(circle);;
		}
	}
	
	public void display(String methodName,Circle circle)
	{
		System.out.println(methodName);
		System.out.println("===========================================");
		System.out.println(circle);
	}


	@Test
	public void contextLoads() {
	}

}
