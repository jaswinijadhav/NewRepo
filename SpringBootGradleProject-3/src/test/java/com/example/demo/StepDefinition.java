package com.example.demo;

import com.example.demo.entity.User;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class StepDefinition {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	@Given("I set POST user service api endpoint")
	public void i_set_post_user_service_api_endpoint() {

		User user = new User(1, "Jaswini", 45, 6787846);
		request = given().contentType(ContentType.JSON).body(user);
		System.out.println("Posting User api");
	}

	@When("send a POST HTTP request")
	public void send_a_post_http_request() {
		response = request.when().post("http://localhost:8081/user/createUser");
		System.out.println(response.prettyPrint());
	}

	@Then("I receive valid Response")
	public void i_receive_valid_response() {
		// Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		json = response.then().statusCode(201);
		System.out.println("Received Response" + json);
	}
	@Given("I set POST user api endpoint {string} {string} {string}")
	public void i_set_post_user_api_endpoint(String name, String age, String phone) {
		User user = new User(1,name,Integer.parseInt(age),Long.parseLong(phone));
		request = given().contentType(ContentType.JSON).body(user);
		System.out.println("Posting User api");
	}
	@When("fill name field with  and fill age field with and phone field with")
	public void fill_name_field_with_and_fill_age_field_with_and_phone_field_with() {
		response = request.when().post("http://localhost:8081/user/createUser");
		System.out.println(response.prettyPrint());
	}

	@Then("I should not able to see data")
	public void i_should_not_able_to_see_data() {
	    // Write code here that turns the phrase above into concrete actions
		json = response.then().statusCode(500);
		System.out.println("Received Response" + json);
	}
}
