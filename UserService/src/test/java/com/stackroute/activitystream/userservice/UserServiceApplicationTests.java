package com.stackroute.activitystream.userservice;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceApplicationTests {
	
	@Autowired
	private static User user;

	@Autowired
	private static UserDAO userDAO;

	@Autowired
	private static AnnotationConfigApplicationContext applicationContext;

	@BeforeClass
	public static void init() {
		applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.scan("com.stackroute.activitystream.backend");
		applicationContext.refresh();
		user = applicationContext.getBean(User.class);
		userDAO = (UserDAO) applicationContext.getBean("userDAO");
	}

	/**
	 * 
	 */
	//@Test
	public void createUserTest() {
		user.setFirstName("abc");
		user.setLastName("abcd");
		user.setEmailId("abc@gmail.com");
		user.setPassword("abc");
		user.setContactNumber("9876235678");
		//user.setUserStatus("Active");
		assertEquals("Registration Successfull", true, userDAO.createUser(user));
	}
	
	  @Test
	  public void authenticateUserTest() 
	  {
		  user.setEmailId("mitali@gmail.com"); 
		  user.setPassword("mitali");
		  assertEquals("Login successfull", User.class,userDAO.authenticateUser(user).getClass());
	  }
	  
	  @Test
	  public void deleteUserTest()
	  {
		  assertEquals("Delete User Test Successfull", true, userDAO.deleteUser("abc@gmail.com"));
	  }
	  
	 /* @Test
	  public void updateUserTestCase()
	  {
		user=userDAO.getUserByUserId("shivani@gmail.com");
		user.setContactNumber("85435678907");
		assertEquals("Update User Test Case Successfull", true,userDAO.updateUser(user));
	  }*/

	@Test
	public void contextLoads() {
	}

}
