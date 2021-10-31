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

public class POST_Testcases {
	@Test
	public void CheckPostResponseSuccess() throws UnirestException, JsonMappingException, JsonProcessingException
	{
		System.out.println("***************** start of testcase :"+Thread.currentThread().getStackTrace()[1].getMethodName()+"*******************");

		System.out.println("Construct a valid POST request body");		
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


		String postApi = "http://localhost:3030/products";

		System.out.println("Send POST request");		
		HttpResponse<JsonNode> response = Unirest.post(postApi)
				.header("accept", "application/json")
				.header("Content-Type", "application/json")
				.body(mapper.writeValueAsString(object))
				.asJson();

		System.out.println("Get the request status");		
		int status = response.getStatus();

		System.out.println("Check that the request status is Success");
		Assert.assertEquals(status, 201);
	}

	@Test
	public void CheckPostResponseSuccessWhenRemoveOptionalParam() throws UnirestException, JsonMappingException, JsonProcessingException
	{
		System.out.println("***************** start of testcase :"+Thread.currentThread().getStackTrace()[1].getMethodName()+"*******************");

		System.out.println("Construct a POST request body with missing optional parameters");		
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode object = mapper.readValue("{\r\n"
				+ "  \"name\": \"string\",\r\n"
				+ "  \"type\": \"string\",\r\n"
				+ "  \"price\": 0,\r\n"
				+ "  \"shipping\": 0,\r\n"
				+ "  \"upc\": \"string\",\r\n"
				+ "  \"description\": \"string\",\r\n"
				+ "  \"manufacturer\": \"string\",\r\n"
				+ "  \"model\": \"string\"\r\n"
				+ "}",ObjectNode.class);



		String postApi = "http://localhost:3030/products";

		System.out.println("Send POST request");		
		HttpResponse<JsonNode> response = Unirest.post(postApi)
				.header("accept", "application/json")
				.header("Content-Type", "application/json")
				.body(mapper.writeValueAsString(object))
				.asJson();

		System.out.println("Get the request status");		
		int status = response.getStatus();

		System.out.println("Check that the request status is Success");
		Assert.assertEquals(status, 201);

	}
	@Test
	public void CheckPostResponseFailWhenRemoveMandatoryParam() throws UnirestException, JsonMappingException, JsonProcessingException
	{
		System.out.println("***************** start of testcase :"+Thread.currentThread().getStackTrace()[1].getMethodName()+"*******************");

		System.out.println("Construct a POST request body with missing mandatory parameters");		
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode object = mapper.readValue("{\"name\":\"alii\","
				+ "  \"price\": 0,\r\n"
				+ "  \"shipping\": 0,\r\n"
				+ "  \"upc\": \"string\",\r\n"
				+ "  \"description\": \"string\",\r\n"
				+ "  \"manufacturer\": \"string\",\r\n"
				+ "  \"model\": \"string\",\r\n"
				+ "  \"url\": \"string\",\r\n"
				+ "  \"image\": \"string\"}",ObjectNode.class);


		String postApi = "http://localhost:3030/products";

		System.out.println("Send POST request");		
		HttpResponse<JsonNode> response = Unirest.post(postApi)
				.header("accept", "application/json")
				.header("Content-Type", "application/json")
				.body(mapper.writeValueAsString(object))
				.asJson();

		System.out.println("Get the request status");		
		int status = response.getStatus();

		System.out.println("Check that the request status is Fail");
		Assert.assertEquals(status, 400);
	}

}
