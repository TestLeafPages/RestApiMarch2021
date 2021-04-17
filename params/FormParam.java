package params;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class FormParam {
	
	@Test
	public void loginLeaftaps() {
		
		// Step 1: Get the URL / Endpoint for the services		
		RestAssured.baseURI = "http://leaftaps.com/opentaps/control/login";
		// Step 2: Request type - Post + form param
		Response post = RestAssured
			.given()
//			.contentType(ContentType.URLENC)
			.when()
			.param("USERNAME", "DemoCSR2")
			.param("PASSWORD", "crmsfa")
			.post();
			
		post.prettyPrint();
		
	}
	

}
