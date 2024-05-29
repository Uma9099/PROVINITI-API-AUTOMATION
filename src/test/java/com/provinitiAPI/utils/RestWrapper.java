package com.provinitiAPI.utils;

import com.provinitiAPI.common.ExtentTestManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.parsing.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;


/**
 * Created by vkuma26 on 8/26/19.
 */
@Component
public class RestWrapper {


  private static final Logger logger = LogManager.getLogger(RestWrapper.class);

	ObjectMapper mapper;



	public String getResponseWithPathParams(String host, String endpointUrl){


		String responseBody = given().log().all().
				baseUri(host).basePath(endpointUrl).expect().defaultParser(Parser.JSON).
				when().get().
				then().extract().asString();




		ExtentTestManager.logStep("Tested with this end point "+host+endpointUrl);
		ExtentTestManager.logStep("Response Body is "+responseBody);
		System.out.println("Response Body"+responseBody);

		return responseBody;
	}


}
