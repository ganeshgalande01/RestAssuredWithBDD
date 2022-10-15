package StepDefinition;

import java.util.HashMap;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class PostStepsdef extends BaseClass{
	
	String email = Randomstring() + "@gmail.com";

	@Given("I set header and body to create new user")
	public void i_set_header_and_body_to_create_new_user() {
		
		
		
		HashMap<String , String> hm_header = new HashMap<String , String>();
		hm_header.put("Content-Type", "application/json");
		
		String payload = "{\r\n"
				+ "    \"name\": \"mintooo Kumar\",\r\n"
				+ "    \"gender\": \"male\",\r\n"
				+ "    \"email\": \""+email+"\",\r\n"
				+ "    \"status\": \"active\"\r\n"
				+ "}";
		req_spec1.headers(hm_header).body(payload);
	}

	@When("I hit the api with post request and end point as {string}")
	public void i_hit_the_api_with_post_request_and_end_point_as(String endpoint) {
	   
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		
		resp1 = req_spec1.when().post(endpoint);
		System.out.println(resp1.asString());
	}

	@Then("API created a new user in the system")
	public void api_created_a_new_user_in_the_system() {
	  
		System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
		
		resp1.then().statusCode(201).assertThat().body("email", equalTo(email));
		
		System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
	}

	@Then("I can find the new user in the system when i get the user")
	public void i_can_find_the_new_user_in_the_system_when_i_get_the_user() {
		
		System.out.println("--------------------------------------------");
	    String id =	resp1.jsonPath().getString("id");
		System.out.println("id of the created user is :" +id);
	
		
		Response response_created = given().baseUri(server1)
		.header("Authorization", "Bearer 748b6d7e9c8ed5900d9942cafc44a5b208b35990ca53792be17b20d9f27e809b")
		.when().get("/public/v2/users/"+id);
		
		System.out.println("getting the response after post :" +response_created.asString());
		
		response_created.then().assertThat().statusCode(200).
		body("name", equalTo("mintooo Kumar"));
		
		
	}

	
	
}
