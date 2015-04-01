package edu.mc2.sms.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.mc2.sms.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class UserDAOTest {

	@Autowired
	private UserDAO userDAO;
	
	
	@BeforeClass
	public  static void beforeClass() {

	}
	
	@AfterClass
	public  static void afterClass() {

	}
	
	
	@Before
	public void before() {

	}
	
	@After
	public void after() {

	}
	
	@Test
	public void test() {
		System.out.println(">>>>>>>>>>>>>>" + userDAO.getCount());
	}

}
