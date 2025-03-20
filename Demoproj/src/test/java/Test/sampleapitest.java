package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import io.cucumber.java.BeforeAll;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;



public class sampleapitest {
	
     public static Properties prop;
     public String body ;
	
     public void createpayload() throws IOException {
    	 byte[] b = Files.readAllBytes(Paths.get("src\\test\\resources\\Api\\Createentry.json"));
    	 body = new String(b);
    	 RequestSpecification request = RestAssured.given();
    	 request.given().header("Content-type", "application/json").body(body);
    	 request.when().post("/posts").then().log().all();
	}
	
	
	public void postapicall() {
	
		RestAssured.baseURI =  prop.getProperty("BasrUri");
		
	}
	
	
	public void validateapiresponse() {
		
	}
	
public void addheaders() {
		
	}

@BeforeAll
public static void testdatasetup() throws FileNotFoundException, IOException {
	File tre = new File("src\\main\\resources\\Properties\\config.properties");
	FileInputStream fis = new FileInputStream(tre);
	prop = new Properties();
	prop.load(fis);
}
	

	 
}
