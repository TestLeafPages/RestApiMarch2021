package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;

public class CucumberAnnotation {

	@Before
	public void pre() {
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
	}
	
	@After
	public void post(Scenario sc) {
		System.out.println(sc.getName()+"---"+sc.getStatus());
	}
	
}
