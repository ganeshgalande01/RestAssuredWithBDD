package StepDefinition;

import java.util.HashMap;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utils.Common_Methods;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UpdateUser_stepdefs extends BaseClass {
	
	String new_Userid = null;
	String nme = Randomstring();
	String email_id = Randomstring() + "@gmail.com";
	
	@Given("I have a new user created in the system")
	public void i_have_a_new_user_created_in_the_system() {
	  
		Common_Methods cm = new Common_Methods();
		new_Userid = cm.create_user();
		System.out.println("new user created with id : "+new_Userid);
	}

	@When("I hit the api with patch request to update the existing user")
	public void i_hit_the_api_with_patch_request_to_update_the_existing_user() {
		
		HashMap<String , String> hm_header = new HashMap<String , String>();
		hm_header.put("Content-Type", "application/json");
		
		String payload ="{\r\n"
				+ "    \"name\": \"Rajesh "+nme+"\",\r\n"
				+ "    \"email\": \""+email_id+"\",\r\n"
				+ "    \"status\": \"active\"\r\n"
				+ "}";

		req_spec1.headers(hm_header).body(payload);
		resp1 = req_spec1.when().patch("/public/v2/users/"+new_Userid);
		
		System.out.println(resp1.asString());
		
	}

	@Then("API should update the user")
	public void api_should_update_the_user() {
		
		resp1.then().assertThat().statusCode(200)
		.body("email", equalTo(email_id));
		
		
	}

	@Then("I can find the updated information for that user")
	public void i_can_find_the_updated_information_for_that_user() {
	    
		Response response_created = given().baseUri(server1)
				.header("Authorization", "Bearer 748b6d7e9c8ed5900d9942cafc44a5b208b35990ca53792be17b20d9f27e809b")
				.when().get("/public/v2/users/"+new_Userid);
		
		
		System.out.println("Response of updated user is :"+response_created.asString());
		
		response_created.then().assertThat().statusCode(200)
		.body("email", equalTo(email_id));
	}
	
	

}
