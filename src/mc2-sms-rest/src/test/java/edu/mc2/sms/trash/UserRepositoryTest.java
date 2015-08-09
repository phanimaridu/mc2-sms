package edu.mc2.sms.trash;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.mc2.sms.Application;
import edu.mc2.sms.jpa.repository.UserRepository;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class UserRepositoryTest {

	//Git Test

	@Autowired
	private UserRepository userDAO;
	
	
	
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

		
	}

}
