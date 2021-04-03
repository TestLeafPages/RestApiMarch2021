package basic;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithMultipleFile {

	@DataProvider(name = "featchData")
	public String[][] getData() {
		// add data in Array -> x * 1
		String[][] data = new String[2][1];
		//row 1
		data[0][0] = "Incident1.json";
		//row 2
		data[1][0] = "Incident2.json";
		return data;
	}	
	
	@Test(dataProvider = "featchData")
	public void createIncidentWithMultipleFile(String jsonPath) {

//		step 1: set EndPoint for the server
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
//		step 2: Authentication (basic auth)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
//		step 3: Request Type
		
		//set the json file path
		File path = new File("./"+jsonPath);
		
	    Response response = RestAssured
	    		.given()
	    		.contentType(ContentType.JSON)
	    	//body -> string, file
	    		.body(path)
	    		.post();// ctrl+2 , l
//		step 5: printing the respones
	    response.prettyPrint();
//		step 4: validation (Statu code -> 201)
	    System.out.println(response.statusCode()); 
	    System.out.println(response.contentType());
		
	}

}
