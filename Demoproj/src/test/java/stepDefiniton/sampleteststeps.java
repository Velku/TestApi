package stepDefiniton;

import java.util.List;
import java.util.Map;

import Test.sampleapitest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class sampleteststeps  {
	
	
	@Given("I prepare payload for POST Api call")
	public void payload(DataTable table) {
		sampleapitest obj = new sampleapitest();
	    Map<String, String> data = table.asMap();
	    String datas = data.toString();
	    System.out.print(datas);
		obj.createpayload();
//	    throw new io.cucumber.java.PendingException();
	}

	@Given("I add the headers")
	public void i_add_the_headers() {
		sampleapitest obj = new sampleapitest();
		obj.addheaders();
//		throw new io.cucumber.java.PendingException();
	}

	@When("I create the post request")
	public void i_create_the_post_request() {
		sampleapitest obj = new sampleapitest();
		obj.postapicall();
//	    throw new io.cucumber.java.PendingException();
	}

	@Then("I validate the API response")
	public void i_validate_the_api_response() {
		sampleapitest obj = new sampleapitest();
		obj.validateapiresponse();
//	    throw new io.cucumber.java.PendingException();
	}

}
