package basic;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllIncidentWithParseResponse {

	public static void main(String[] args) {

//		step 1: set EndPoint for the server
		//className.methodName
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
//		step 2: Authentication (basic auth)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
//		step 3: Request Type
	    Response response = RestAssured
	    		.given()
	    		.queryParam("category","software")
//	    		.queryParam("sysparm_fields", "sys_id, number, category")
	    		.get();// ctrl+2 , l
//		step 5: printing the respones
//	    response.prettyPrint();
//		step 4: validation (Statu code -> 200)
	    System.out.println(response.statusCode()); 
	    System.out.println(response.contentType());
	    
	    // parse in to json
	    JsonPath json = response.jsonPath();
	    // get all incident number
	    //json.get(path) -> fetch 1st matching value
	    String number = json.get("result.number[0]");
	    System.out.println(number);
	    
	    
	    //json.getList(path) - > fetch all value
	   /* List<String> listNumber = json.getList("result.number");
	    
	    
	    for (String eachNumber : listNumber) {
			System.out.println(eachNumber);
		}*/
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
		
	}

}
