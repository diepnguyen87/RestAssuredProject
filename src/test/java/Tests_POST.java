import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Tests_POST {

	//@Test
	void test_01_post() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "morpheus");
//		map.put("job", "leader");
		
		JSONObject request = new JSONObject();
		request.put("name", "morpheus");
		request.put("job", "leader");
		System.out.println(request.toJSONString());
		
		given()
			.header("Content-Type", "Application/Json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201);
			
	}
	
	//@Test
	void test_02_put() {
		JSONObject request = new JSONObject();
		request.put("name", "Diep");
		request.put("job", "Automtion");
		System.out.println(request.toJSONString());
		
		given()
			.header("Content-Type", "Application/Json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.put("https://reqres.in/api/users/2")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	//@Test
	void test_03_patch() {
		JSONObject request = new JSONObject();
		request.put("name", "Diep");
		request.put("job", "Testing");
		System.out.println(request.toJSONString());
		
		given()
			.header("Content-Type", "Application/Json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.patch("https://reqres.in/api/users/2")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	void test_04_delete() {
		
		when()
			.delete("https://reqres.in/api/users/2")
		.then()
			.statusCode(200)
			.log().all();
	}
}
