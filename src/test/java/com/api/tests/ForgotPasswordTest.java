package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class ForgotPasswordTest {

	@Test(description ="Verify if the forgot password API is working....")
	public void forgotPasswordTest() {
		
		AuthService authService = new AuthService();
		Response response = authService.forgotPassword("torida1080@etenx.com");
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(),200);
		
		
		
		
		
		
	}
	
	
}
