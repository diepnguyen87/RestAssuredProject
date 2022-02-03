import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.*;
import java.nio.charset.Charset;

import org.apache.commons.collections4.functors.IfClosure;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;

public class SoapXMLRequest {

	@Test
	public void validateSoapXML() throws IOException {
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
			.body("//AddResult.text()", equalTo("9"));
		
	}
}
