package com.boot;

import java.io.IOException;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class ShipwreckControllerWebtest {
	@Test
	public void testAll() throws JsonProcessingException, IOException {
		TestRestTemplate restTemplate = new TestRestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/api/v1/shipwrecks", String.class);
		Assert.assertThat(response.getStatusCode(), Matchers.equalTo(HttpStatus.OK));
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode responseJson = mapper.readTree(response.getBody());
		Assert.assertThat(responseJson.isMissingNode(), Matchers.is(false));
	}
}
