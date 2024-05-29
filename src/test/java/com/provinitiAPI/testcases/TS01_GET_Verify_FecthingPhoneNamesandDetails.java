package com.provinitiAPI.testcases;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.provinitiAPI.common.ExtentTestManager;
import com.provinitiAPI.common.TestBase;
import com.provinitiAPI.dto.DataDTO;
import com.provinitiAPI.dto.RootDTO;
import com.provinitiAPI.testservices.ProvinitiServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

import static com.provinitiAPI.constants.Constants.PROVINITI_SEARCH_STRING_APPLE;
import static com.provinitiAPI.constants.ResourceEndPoints.PROVINITI_SERVICE_BASE_VERIFY_OBJECTS;


@SpringBootTest
public class TS01_GET_Verify_FecthingPhoneNamesandDetails extends TestBase {

    @Autowired
    ProvinitiServices provinitiServices;


    ObjectMapper mapper = new ObjectMapper();

    @Test()
    @SneakyThrows
    public void Proviniti_TC_01_GET_FetchAndVerify_all_phone_names_starting_with_word_apple() {
        ExtentTestManager.startTest(
                "1_Get_all_phone_names_starting_with_word_apple.",
                "Verify" +
                        "Get_all_phone_names_starting_with_word_apple.");

        mapper = new ObjectMapper();

        // Hitting the given end point and fetching the Json Response in String format

        String res = provinitiServices.getproviniti(PROVINITI_SERVICE_BASE_VERIFY_OBJECTS);
        //root = mapper.readTree(res.getBody().asString());

        // Deserialing the Json String in to Java Class Object - Pojo Class
        List<RootDTO> ListofPhones = Arrays.asList(mapper.readValue(res, RootDTO[].class));

        List<String> phoneNamesList=new ArrayList<>();
        // Extracting the objects having  "Apple" as the first word in their phone names
        List<RootDTO> phoneList= ListofPhones.stream().filter(name->name.getName().startsWith(PROVINITI_SEARCH_STRING_APPLE)).collect(Collectors.toList());

        //adding only  phone names from the response Object  that are matching the search creteria  to a List<String> object
        for(RootDTO root:phoneList)
        {
            phoneNamesList.add(root.getName());

        }


        // if the search creteira matches the resultant  Listof Phone names will be printed
        if(!phoneNamesList.isEmpty())
        {
            ExtentTestManager.logStepPass("Extracted phones names having first word as "+PROVINITI_SEARCH_STRING_APPLE+" are \n" + phoneNamesList);
        }
        // if the search creteira Does  NOT matches same  information will be logged in the extent report
        else
        {
            ExtentTestManager.logStep("Extracted phones names  are NOT having first word as" +PROVINITI_SEARCH_STRING_APPLE);
        }


    }


    @Test()
    @SneakyThrows
    public void Proviniti_TC_02_GET_get_phone_with_lowest_cost() {
        ExtentTestManager.startTest(
                "2.Get phone with lowest cost.",
                "Verify" +
                        "Get phone with lowest cost.");

        mapper = new ObjectMapper();

        // Hitting the given end point and fetching the Json Response in String format

        String res = provinitiServices.getproviniti(PROVINITI_SERVICE_BASE_VERIFY_OBJECTS);
        //root = mapper.readTree(res.getBody().asString());

        // Deserialing the Json String in to Java Class Object - Pojo Class
        //List<RootDTO> ListofPhones = Arrays.asList(mapper.readValue(res, RootDTO[].class));
        RootDTO [] ListofPhones =mapper.readValue(res, RootDTO[].class);
        // TODO
        //As price field is not unique as   2 types of price fields are returned in Json Response  like Price: 519.99 and  price: 120 where 2 field names
        // are different  and values returned are also different leaving this validation for now till the time clarificaiton is given

        Comparator<DataDTO> sortonPrice = Comparator.comparingDouble(DataDTO::getPrice1);
         ExtentTestManager.logStep("As price field is not unique as   2 types of price fields are returned in Json Response  like Price: 519.99 and  price: 120 where 2 field names are different  and values returned are also different leaving this validation for now till the time clarificaiton is given   ");

    }


    @Test()
    @SneakyThrows
    public void Proviniti_TC_03_GET_validate_that_ID_is_not_null() throws JsonProcessingException {
        ExtentTestManager.startTest(
                "3_validate that ID is not null.",
                "Verify" +
                        "validate that ID is not null");

        mapper = new ObjectMapper();

        // Hitting the given end point and fetching the Json Response in String format

        String res = provinitiServices.getproviniti(PROVINITI_SERVICE_BASE_VERIFY_OBJECTS);
              // Deserialing the Json String in to Java Class Object - Pojo Class
        List<RootDTO> ListofPhones = Arrays.asList(mapper.readValue(res, RootDTO[].class));
        boolean idNullCheck=false;
        for(RootDTO rdto:ListofPhones)
        {
            if(Objects.isNull(rdto.getId()))
            {
                idNullCheck=true;
            }
        }
        Assert.assertEquals(idNullCheck,false);
        ExtentTestManager.logStepPass("Id is not Null");

    }

}

