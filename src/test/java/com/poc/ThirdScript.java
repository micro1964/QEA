package com.poc;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

@Listeners(com.testautomationuniversity.web.utilities.TestListener.class)
public class ThirdScript {
	/*
	 * Restful API Testing using RestAssured
	 * Given - Prerequisite Conditions
	 * When - The Action that takes place
	 * Then - The expected results
	 */
	
	@Test
	public void restPocFirstTestCase() {
		
		ArrayList <Integer> id = new ArrayList<Integer>();
		ArrayList <String> employee_name = new ArrayList<String>();
		ArrayList <Integer> employee_salary = new ArrayList<Integer>();
		ArrayList <Integer> employee_age = new ArrayList<Integer>();
		
		String sUrl = "https://dummy.restapiexample.com";
		String sResource = "/api/v1/employees";
		int iStatusCode = 200;
		
		RestAssured.baseURI = sUrl;
		
		String response = given().when()
		.get(sResource)
		.then().assertThat().log().all()
		.statusCode(iStatusCode).extract().response().asString();
		
		JsonPath js = new JsonPath(response);
		String sStatus = js.getString("status");
		String sMessage = js.getString("message");
		
		int iData = js.getInt("data.size()");
		for(int i=0; i<iData;i++) {
			id.add(js.getInt("data["+i+"].id"));
			employee_name.add((String) js.get("data["+i+"].employee_name"));
			employee_salary.add(js.getInt("data["+i+"].employee_salary"));
			employee_age.add(js.getInt("data["+i+"].employee_age"));
			}
		
		Assert.assertEquals(employee_name.size(), iData);
		Assert.assertEquals(employee_salary.size(), iData);
		Assert.assertEquals(employee_age.size(), iData);
		Assert.assertEquals(sStatus,"success");
		Assert.assertEquals(sMessage, "Successfully! All records has been fetched.");		
	}
	
}
