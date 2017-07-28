package com.stackroute.activitystream.usercircleservice;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserCircleServiceApplicationTests {
	
	@Autowired
	private static UserCircle userCircle;

	@Autowired
	private static UserCircleDAO userCircleDAO;

	@Autowired
	private static AnnotationConfigApplicationContext applicationContext;

	@BeforeClass
	public static void init() {
		applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.scan("com.stackroute.activitystream.backend");
		applicationContext.refresh();
		userCircle = applicationContext.getBean(UserCircle.class);
		userCircleDAO = (UserCircleDAO) applicationContext.getBean("userCircleDAO");
	}
	
	@Test
	public void addUserToCircleTest()
	{
		
	}
	
	@Test
	public void removeUserFromCircle()
	{
		
	}

	@Test
	public void contextLoads() {
	}

}
