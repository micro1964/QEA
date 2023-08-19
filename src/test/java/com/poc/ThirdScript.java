package com.poc;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class ThirdScript {
	/*
	 * Restful API Testing using RestAssured
	 * Given - Prerequisite Conditions
	 * When - The Action that takes place
	 * Then - The expected results
	 */
	
	@Test
	public void restPocFirstTestCase() {
		String sUrl = "https://dummy.restapiexample.com";
		String sResource = "/api/v1/employees";
		int iStatusCode = 200;
		
		RestAssured.baseURI = sUrl;
		
		String response = given().when()
		.get(sResource)
		.then().assertThat()
		.statusCode(iStatusCode).extract().response().asString();
		
		JsonPath js = new JsonPath(response);
		String sStatus = js.getString("status");
		Assert.assertEquals(sStatus,"success");
		
	}
	


}
