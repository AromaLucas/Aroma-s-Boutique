package com.niit.ABBackEnd;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.UserDAO;
import com.niit.Model.User;

public class UserDAOTest {
static UserDAO userDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	
	@Test
	public void registerUserTest()
	{
		User user=new User();
		
		user.setUsername("Teddy");
		user.setCustomerName("Teddy");
		user.setAddress("G3, D Block, RC Adena Appartments, Thirumullaivoyal, Chennai, 600062");
		user.setEmail("Teddy22@gmail.com");
		user.setEnabled(true);
		user.setNumber("987654321");
		user.setPassword("teddy123");
		user.setRole("ROLE_ADMIN");
		
		assertTrue("Problem in Registering User:",userDAO.registerUser(user));
	}
	
	@Ignore
	@Test
	public void updateUserTest()
	{
		User user=new User();
		
		user.setUsername("Teddy123");
		user.setCustomerName("Teddy");
		user.setAddress("Door no 223, ABC appartments");
		user.setEmail("Teddy22@gmail.com");
		user.setEnabled(true);
		user.setNumber("987654321");
		user.setPassword("teddy123");
		user.setRole("ROLE_ADMIN");
		
		assertTrue("Problem in Registering User:",userDAO.registerUser(user));
	}


}