package demo;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenExample1 extends DataForTests{

	//@Test(dataProvider = "dataForPost")
	public void test_post(String firstName, String lastName, int subjectID) {
		JSONObject request = new JSONObject();
		request.put("firstName", firstName);
		request.put("lastName", lastName);
		request.put("subjectId", subjectID);
		
		baseURI = "http://localhost:3000";
		
		given()
			.header("Content Type", "Application/Json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.post("/users")
		.then()
			.statusCode(201)
			.log().all();
	}
	
	//@Test(dataProvider = "deletedData")
	public void test_delete_1(int userID) {
		baseURI = "http://localhost:3000";
		
		when()
			.delete("/users/" + userID)
		.then()
			.statusCode(200)
			.log().all();
	}

	@Parameters({"userID"})
	@Test
	public void test_delete_2(int userID) {
		baseURI = "http://localhost:3000";
		
		when()
			.delete("/users/" + userID)
		.then()
			.statusCode(200)
			.log().all();
	}
		
	
}
