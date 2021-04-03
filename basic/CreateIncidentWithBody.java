package basic;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithBody {

	public static void main(String[] args) {

//		step 1: set EndPoint for the server
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue/";
//		step 2: Authentication (basic auth)
		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com", "1tFDjllY3jwISCost2cZ8C09");
//		step 3: Request Type
	    Response response = RestAssured
	    		.given()
	    		.contentType(ContentType.JSON)
	    	//body -> string, file
	    		.body("{ \"fields\": { \"project\": { \"key\": \"RA\" }, \"summary\": \"create issue in MAY project from file1\", \"description\": \"Creating of an issue using project keys and issue type names using the REST API from File1\", \"issuetype\": { \"name\": \"Bug\" } }}")
	    		.post();// ctrl+2 , l
//		step 5: printing the respones
	    response.prettyPrint();
//		step 4: validation (Statu code -> 201)
	    System.out.println(response.statusCode()); 
	    System.out.println(response.contentType());
		
	}

}
