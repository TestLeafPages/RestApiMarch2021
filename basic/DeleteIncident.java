package basic;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteIncident {

	public static void main(String[] args) {

//		step 1: set EndPoint for the server
		//className.methodName
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
//		step 2: Authentication (basic auth)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
//		step 3: Request Type
	    Response response = RestAssured
	    		.given()
	    		.pathParam("sysId", "8ef2bb952f172010a99d857cf699b61a")
	    		.delete("{sysId}");
//		step 5: printing the respones
	    response.prettyPrint();
//		step 4: validation (Statu code -> 204)
	    System.out.println(response.statusCode()); 
		
	}

}
