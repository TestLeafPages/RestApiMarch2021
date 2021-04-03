package basic;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIssue {

	public static void main(String[] args) {

//		step 1: set EndPoint for the server
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
//		step 2: Authentication (basic auth)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
//		step 3: Request Type
	    Response response = RestAssured
	    		.given()
	    		.contentType(ContentType.JSON)
	    	//body -> string, file
	    		.body("{\"short_description\": \"Create Post from RestAssured with body\",\"category\": \"hardware\"}")
	    		.post();// ctrl+2 , l
//		step 5: printing the respones
	    response.prettyPrint();
//		step 4: validation (Statu code -> 201)
	    System.out.println(response.statusCode()); 
	    System.out.println(response.contentType());
		
	}

}
