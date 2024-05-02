package com.example.springboottask.service;

import com.example.springboottask.DataValidation;
import com.example.springboottask.ErrorResponse;
import com.example.springboottask.controller.TaskController;
import com.example.springboottask.entity.AssignmentJobProperties;
import com.example.springboottask.entity.Details;
import com.example.springboottask.entity.Store;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static javax.management.Query.eq;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MyServiceImplTest {

    //private DataValidation dataValidation=mock(DataValidation.class);
    //private ObjectMapper objectMapper=mock(ObjectMapper.class);
//    private Details details = new Details("actionType", "s3SourceLocation", "s3TargetLocation",
//            new AssignmentJobProperties(List.of(
//                    new Store("UNIQUE_ID", "value1"),new Store("ADDRESS_STREET1","value1")
//                    ,new Store("PHONE_NUMBER","value1"),new Store("EMAIL_ADDRESS","value1")
//            )));
    private MyServiceImpl myService=new MyServiceImpl();

   @Autowired
    TaskController taskController=new TaskController(myService);
    String json="{\n" +
            "    \"actionType\": \"ID_ASSIGNMENT\",\n" +
            "    \"s3SourceLocation\": null,\n" +
            "    \"s3TargetLocation\": \"s3a://venice-dev/test_1m_recs/venice_output_loose_scrub/output_dataset/\",\n" +
            "    \"jobProperties\": {\n" +
            "        \"assignmentJobProperties\": {\n" +
            "            \"fieldMappings\": [\n" +
            "                {\n" +
            "                    \"name\": \"UNIQUE_ID\",\n" +
            "                    \"value1\": \"1\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"ADDRESS_STREET1\",\n" +
            "                    \"value1\": \"ADDRESS_STREET1\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"ADDRESS_CITY\",\n" +
            "                    \"value1\": \"ADDRESS_CITY\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"ADDRESS_STATE\",\n" +
            "                    \"value1\": \"ADDRESS_STATE\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"ADDRESS_POSTALCODE\",\n" +
            "                    \"value1\": \"ADDRESS_POSTALCODE\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"NAME_FIRST\",\n" +
            "                    \"value1\": \"NAME_FIRST\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"NAME_LAST\",\n" +
            "                    \"value1\": \"NAME_LAST\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"PHONE_NUMBER\",\n" +
            "                    \"value1\": \"PHONE_NUMBER\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"EMAIL_ADDRESS\",\n" +
            "                    \"value1\": \"EMAIL_ADDRESS\"\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    }\n" +
            "}";
    String json1="{\n" +
            "    \"actionType\": \"ID_ASSIGNMENT\",\n" +
            "    \"s3SourceLocation\": \"s3a://venice-dev/test_1m_recs/sample_input_1000/\",\n" +
            "    \"s3TargetLocation\": \"s3a://venice-dev/test_1m_recs/venice_output_loose_scrub/output_dataset/\",\n" +
            "    \"jobProperties\": {\n" +
            "        \"assignmentJobProperties\": {\n" +
            "            \"fieldMappings\": [\n" +
            "                {\n" +
            "                    \"name\": \"ADDRESS_STREET1\",\n" +
            "                    \"value1\": \"ADDRESS_STREET1\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"ADDRESS_CITY\",\n" +
            "                    \"value1\": \"ADDRESS_CITY\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"ADDRESS_STATE\",\n" +
            "                    \"value1\": \"ADDRESS_STATE\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"ADDRESS_POSTALCODE\",\n" +
            "                    \"value1\": \"ADDRESS_POSTALCODE\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"NAME_FIRST\",\n" +
            "                    \"value1\": \"NAME_FIRST\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"NAME_LAST\",\n" +
            "                    \"value1\": \"NAME_LAST\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"PHONE_NUMBER\",\n" +
            "                    \"value1\": null\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"EMAIL_ADDRESS\",\n" +
            "                    \"value1\": \"EMAIL_ADDRESS\"\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    }\n" +
            "}";

    @Test
    void checkIfValidationIsTrue() throws JsonProcessingException {
//        when(objectMapper.readValue(json,Details.class)).thenReturn(details);
//        when(dataValidation.isValid()).thenReturn(true);
        //ObjectMapper objectMapper=new ObjectMapper();
//        Details details=objectMapper.readValue(json,Details.class);
//        System.out.println(details.getS3SourceLocation());
        ResponseEntity responseEntity=taskController.postData(json);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
    @Test
    void checkIfValidationIsFalse() throws JsonProcessingException {
        ResponseEntity responseEntity=taskController.postData(json);
        assertEquals(HttpStatus.NOT_IMPLEMENTED,responseEntity.getStatusCode());
    }
    @Test
    void checkWhenMandatoryFieldsAreMissing() throws JsonProcessingException {
        ResponseEntity responseEntity=taskController.postData(json1);
        ErrorResponse errorResponse=(ErrorResponse) responseEntity.getBody();
        System.out.println(responseEntity);
        assertTrue(errorResponse.getMessage().toString().contains("UNIQUE_ID"));
        //assertEquals("UNIQUE_ID is missing  ", errorResponse.getMessage().toString());
    }
    @Test
    void checkIfAnyValueIsNull() throws JsonProcessingException {
        ResponseEntity responseEntity=taskController.postData(json1);
        ErrorResponse errorResponse=(ErrorResponse) responseEntity.getBody();
        assertTrue(errorResponse.getMessage().toString().contains("PHONE_NUMBER is null"));
    }
    @Test
    void checkIfSourceIsNull() throws JsonProcessingException {
        ResponseEntity responseEntity=taskController.postData(json);
        ErrorResponse errorResponse=(ErrorResponse) responseEntity.getBody();
        assertEquals("s3SourceLocation is null",errorResponse.getMessage().toString());
    }
    @Test
    void checkIfTargetIsNull() throws JsonProcessingException{
        ResponseEntity responseEntity=taskController.postData(json);
        ErrorResponse errorResponse=(ErrorResponse) responseEntity.getBody();
        assertEquals("s3TargetLocation is null",errorResponse.getMessage().toString());
    }




}