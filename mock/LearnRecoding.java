package mock;
import org.codehaus.groovy.control.customizers.builder.PostCompletionFactory;
import org.mozilla.javascript.ast.WithStatement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LearnRecoding {
	

	@Test
	public void createIncident() {
		RestAssured.baseURI = "http://localhost:8080/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		Response response = RestAssured
						.given()
						.log().all()
						.contentType(ContentType.JSON)
						.post()
						.then()
						.assertThat()
						.contentType(ContentType.JSON)
						.statusCode(201)
						.extract().response();
		
		response.prettyPrint();
	}


}
