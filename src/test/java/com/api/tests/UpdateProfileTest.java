package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {

	
	@Test(description = "Verify User is able to update the User information...")
	public void updateProfileTest() {
		
		AuthService authService = new AuthService();
		 Response response= authService.login(new LoginRequest("shiva007", "welcome123"));
		 LoginResponse loginResponse = response.as(LoginResponse.class);
		 System.out.println(response.asPrettyString());
		 
		 System.out.println("--------------------------------------------------------------------------");
		 
		 
		 UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		 response = userProfileManagementService.getProfile(loginResponse.getToken());
		 System.out.println(response.asPrettyString());
		 UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		 Assert.assertEquals(userProfileResponse.getUsername(), "shiva007");
		 
		 System.out.println("--------------------------------------------------------------------------");
		 
		 ProfileRequest profileRequest = new ProfileRequest.Builder()
				 	.firstName("TestShiva")
				 	.lastName("Test Shiva")
				 	.email("pleasantshiva1@gmail.com")
				 	.mobileNumber("9090909090")
				 	.build();
		 
		 response = userProfileManagementService.updateProfile(loginResponse.getToken(),profileRequest);
		 System.out.println(	response.asPrettyString());
		 
		
		
	}
	
	
}
