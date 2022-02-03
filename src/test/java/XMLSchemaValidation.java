import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;

public class XMLSchemaValidation {

	@Test
	public void schemaValidation() throws IOException {
		baseURI = "http://www.dneonline.com/";
		File file = new File("./SoapRequest/Add.xml");
		
		if (file.exists()){
			System.out.println("    >>> File Exists");
		}
		
		FileInputStream input = new FileInputStream(file);
		String body = IOUtils.toString(input, "UTF-8");
		given()
			.contentType("text/xml")
			.accept(ContentType.XML)
			.body(body)
		.when()
			.post("/calculator.asmx")
		.then()
			.statusCode(200)
			.log().all()
		.and()
			.body("//AddResult.text()", equalTo("9"))
		.and()
			.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("Add.xsd"));
		
	}
}
