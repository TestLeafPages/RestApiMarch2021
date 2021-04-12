package channing;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIncidentWithOutBody extends Common {

	@Test
	public void createIncidentWithOutBody() {
    		
//		step 1: set EndPoint for the server
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
//		step 2: Authentication (basic auth)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
//		step 3: Request Type
	     Response response = RestAssured
	    		.given()
	    		//enable log
	    		.log().all()
	    		.contentType(ContentType.JSON)
	    		.post()
	    		;// ctrl+2 , l
//		step 5: printing the respones
	    response.prettyPrint();
//		step 4: validation (Statu code -> 201)
	    System.out.println(response.statusCode()); 
	    System.out.println(response.contentType());
		
	   sys_id  = response.jsonPath().get("result.sys_id");
	    
	}

}
