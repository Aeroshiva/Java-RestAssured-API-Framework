package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignupRequest;

import io.restassured.response.Response;

public class AccountCreationTest {

	@Test(description ="Verify if the signup is working....")
	public void createAccountTest() {
		SignupRequest signupRequest = new SignupRequest.Builder()
					.username("trackapi7")
					.password("1234As")
					.email("torida1080@etenx.com")
					.firstName("fname")
					.lastName("lname")
					.mobileNumber("9898989809")
					.build();
		
		AuthService authService = new AuthService();
		Response response = authService.signup(signupRequest);
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(),200);
		Assert.assertTrue(response.asString().contains("User registered successfully!"));
		
		
		
		
		
		
	}
	
	
}
