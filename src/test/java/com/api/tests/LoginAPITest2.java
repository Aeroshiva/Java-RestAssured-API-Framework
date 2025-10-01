package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;
@Listeners(com.api.listeners.TestListener.class)
public class LoginAPITest2 {


	@Test(description = "verify if the login is working....")
	public void loginTest() {
		LoginRequest loginRequest = new LoginRequest("shiva007", "welcome123");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(),200);
		
		
		  LoginResponse loginResponse = response.as(LoginResponse.class);
		  System.out.println(loginResponse.getEmail());
		  System.out.println(loginResponse.getId());
		  System.out.println(loginResponse.getToken());
		  System.out.println(loginResponse.getUsername());
		  System.out.println(loginResponse.getRoles());
		  
		  Assert.assertTrue(loginResponse.getToken() !=null);
		  Assert.assertEquals(loginResponse.getEmail(),"pleasantshiva1@gmail.com");
		  Assert.assertEquals(loginResponse.getId(), 2864);
		 
		

	}


}
