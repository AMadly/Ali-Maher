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

public class DELETE_Testcases {

	@Test
	public void PostThenDeleteNewProductByID() throws UnirestException, JsonMappingException, JsonProcessingException
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
		String id = response.getBody().toString().substring(209, 216);
		System.out.println("Product has been created with Id:" + id);

		System.out.println("Check that POST response is success");
		Assert.assertEquals(status, 201);


		String url = "http://localhost:3030/products/" + id;

		System.out.println("Send DELETE request");
		int body = Unirest.delete(url)
				.asJson()
				.getStatus();

		System.out.println("Check that DELETE response is success");
		Assert.assertEquals(body, 200);
	}

	@Test
	public void PostThenDeleteNewProductByIDx2() throws UnirestException, JsonMappingException, JsonProcessingException
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
		String id = response.getBody().toString().substring(209, 216);
		System.out.println("Product has been created with Id:" + id);

		System.out.println("Check that POST response is success");
		Assert.assertEquals(status, 201);

		String url = "http://localhost:3030/products/" + id;

		System.out.println("Send DELETE request");
		int body = Unirest.delete(url)
				.asJson()
				.getStatus();

		System.out.println("Check that First DELETE response is success");
		Assert.assertEquals(body, 200);

		System.out.println("Send a second DELETE request");
		body = Unirest.delete(url)
				.asJson()
				.getStatus();

		System.out.println("Check that Second DELETE response is success");
		Assert.assertEquals(body, 404);

	}


}
