package utils;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import StepDefinition.BaseClass;
import io.restassured.response.Response;

public class Common_Methods extends BaseClass{

	public String create_user()
	{
		
		String email = Randomstring() + "@gmail.com";
		String name = Randomstring();
		
		HashMap<String , String> hm_header = new HashMap<String , String>();
		hm_header.put("Content-Type", "application/json");
		
		String payload = "{\r\n"
				+ "    \"name\": \"Mayank"+name+"\",\r\n"
				+ "    \"gender\": \"male\",\r\n"
				+ "    \"email\": \""+email+"\",\r\n"
				+ "    \"status\": \"active\"\r\n"
				+ "}";
		
	Response response =	given().baseUri(server1)
		.header("Authorization", "Bearer 748b6d7e9c8ed5900d9942cafc44a5b208b35990ca53792be17b20d9f27e809b")
		.headers(hm_header).body(payload).when().post("/public/v2/users/");
		
	System.out.println("response for new user created via common method class is :" +response.asString());
	
	String id = response.jsonPath().getString("id");
	
	System.out.println("id of the created user from common class method is " +id);
	
	return id;
		
		
	}
	
	
	
	
}
