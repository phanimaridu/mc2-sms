package edu.mc2.sms.cntrlr.rest.common;


import java.util.Arrays;

import org.apache.http.HttpHeaders;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import edu.mc2.sms.Application;
import edu.mc2.sms.jpa.entity.User;
import edu.mc2.sms.util.RestUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class UserControllerTest {

	//TODO:Get port number from properties
	private String USER_URI = "http://localhost:8081/users/";
	
	private RestTemplate template = new TestRestTemplate();
	
	
	@BeforeClass
	public static void beforeClass() {
		//at the beginning of test add different users with different roles
	}
	
	@AfterClass
	public static void afterClass() {
		//delete all created users and roles
	}
	
	@Before
	public void before() {

	}
	
	@After
	public void after() {

	}
	
	@Test
	public void test() {
		
		User[] users = template.exchange(USER_URI, HttpMethod.GET, 
				new HttpEntity<HttpHeaders>(RestUtil.createHeaders("phanimaridu", "123")),  User[].class).getBody();
		
		System.out.println(">>>>>>>>>>>>>>" + Arrays.asList(users));

		//Employee[] list = restTemplate.getForObject("<some URI>", Employee[].class);
		/*
		 ResponseEntity<TblGps[]> responseEntity = restTemplate.getForEntity(urlGETList, TblGps[].class);
		 TblGps[]=responseEntity.getBody();
		 */
	}
	
}