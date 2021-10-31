package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class GET_Testcases {

	@Test
	public void CheckGetResponseSuccess() throws UnirestException  
	{
		String id = "43900";
		String url = "http://localhost:3030/products/" + id;

		System.out.println("***************** start of testcase :"+Thread.currentThread().getStackTrace()[1].getMethodName()+"*******************");

		System.out.println("Send a GET request to valid id:" + url);
		int body = Unirest.get(url)
				.asJson()
				.getStatus();

		System.out.println("Check Success response received");
		Assert.assertEquals(body, 200);

	}

	@Test
	public void CheckGetResponseFail() throws UnirestException  
	{
		String id = "439000000";
		String url = "http://localhost:3030/products/" + id;

		System.out.println("***************** start of testcase :"+Thread.currentThread().getStackTrace()[1].getMethodName()+"*******************");

		System.out.println("Send a GET request to non-existing id:" + url);

		int body = Unirest.get(url)
				.asJson()
				.getStatus();

		System.out.println("Check Not Found response received");
		Assert.assertEquals(body, 404);

	}


	@Test
	public void PostThenGetNewProductByID() throws UnirestException, JsonMappingException, JsonProcessingException
	{
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode object = mapper.readValue("{\"name\":\"alii\","
				+ "\"type\": \"string\",\r\n"
				+ "  \"price\": 0,\r\n"
				+ "  \"shipping\": 0,\r\n"
				+ "  \"upc\": \"string\",\r\n"
				+ "  \"description\": \"string\",\r\n"
				+ "  \"manufacturer\": \"string\",\r\n"
				+ "  \"model\": \"string\",\r\n"
				+ "  \"url\": \"string\",\r\n"
				+ "  \"image\": \"string\"}",ObjectNode.class);

		System.out.println("***************** start of testcase :"+Thread.currentThread().getStackTrace()[1].getMethodName()+"*******************");

		System.out.println("Send POST request");
		String postApi = "http://localhost:3030/products";
		HttpResponse<JsonNode> response = Unirest.post(postApi)
				.header("accept", "application/json")
				.header("Content-Type", "application/json")
				.body(mapper.writeValueAsString(object))
				.asJson();

		System.out.println("Get the POST request status");
		int status = response.getStatus();

		String id = response.getBody().toString().substring(209, 216);
		System.out.println("Get the created product's ID:"+ id);

		System.out.println("Check Success response received on POST");
		Assert.assertEquals(status, 201);

		String url = "http://localhost:3030/products/" + id;
		int body = Unirest.get(url)
				.asJson()
				.getStatus();

		System.out.println("Check Success response received on GET");
		Assert.assertEquals(body, 200);
	}

	@Test
	public void CheckGetIdContainsCorrectName() throws UnirestException
	{
		String id = "43900";

		System.out.println("***************** start of testcase :"+Thread.currentThread().getStackTrace()[1].getMethodName()+"*******************");

		System.out.println("Send GET request for an existing product");
		String url = "http://localhost:3030/products/" + id;
		JsonNode body = Unirest.get(url)
				.asJson()
				.getBody();

		System.out.println("Check that the product contains: Alkaline Batteries");
		Assert.assertTrue(body.toString().contains("Alkaline Batteries"));;

	}

	@Test(enabled = true)
	public void CheckGetIdWithIncorrectName() throws UnirestException
	{
		String id = "333179";

		System.out.println("***************** start of testcase :"+Thread.currentThread().getStackTrace()[1].getMethodName()+"*******************");

		System.out.println("Send GET request for an existing product");
		String url = "http://localhost:3030/products/" + id;
		JsonNode body = Unirest.get(url)
				.asJson()
				.getBody();

		System.out.println("Check that the product DOES NOT contain: Alkaline Batteries");
		Assert.assertFalse(body.toString().contains("Alkaline Batteries"));;
	}


}
