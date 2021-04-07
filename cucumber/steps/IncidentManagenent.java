package steps;

import java.io.File;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class IncidentManagenent {

	private static RequestSpecification requestSpecification = null;
	private static Response response;
	
//	@Given("set the End point")
//	public void setEndPoint() {
//		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
//	}
//
//	@And("set the Authorization")
//	public void setAuthorization() {
//		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
//	}
//
//	@And("set the ContentType as Json")
//	public void setContentType() {
//		requestSpecification = RestAssured
//				.given()
//				.contentType(ContentType.JSON);
//	}

	@When("send the request as post")
	public void CreateIncident() {
		response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.post();
	}

	@When("send the request as post with short_description as (.*)$")
	public void CreateIncidentWithBody(String fileName) {
		
		response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(new File("./"+fileName))
				.post();
	}
	
	@Then("Confirm the response status code as (.*)$")
	public void verifyStatusCode(int statusCode) {
		response
		.then()
		.assertThat()
		.statusCode(statusCode)
		.extract().response()
		.prettyPrint();
	}


}
