package basic;

import java.util.Map;
import java.util.Map.Entry;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllIncidentWithCookies {

	public static void main(String[] args) {

//		step 1: set EndPoint for the server
		//className.methodName
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
//		step 2: Authentication (basic auth)
//		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
//		step 3: Request Type
	    Response response = RestAssured
	    		.given()
	    		.cookie("JSESSIONID","86A441C02DBE3B3C31A714BF82E878FB")
	    		.queryParam("category","software")
	    		.queryParam("sysparm_fields", "sys_id, number, category")
//	    		.accept("application/xml")
	    		.accept(ContentType.XML)
	    		.get();// ctrl+2 , l
//		step 5: printing the respones
	    response.prettyPrint();
//		step 4: validation (Statu code -> 200)
	    System.out.println(response.statusCode()); 
	    System.out.println(response.contentType());
	    
	    
	    
	    Map<String, String> allCookies = response.getCookies();
	    
	    
	   for(Entry<String, String> eachEntry : allCookies.entrySet())// key1 -> value1,key2 -> value2,key3 -> value3 => entrySet 
	   {
		   System.out.println(eachEntry.getKey()+"---->"+eachEntry.getValue());
	   }
	    
	    
	    
	    
	    
		
	}

}
