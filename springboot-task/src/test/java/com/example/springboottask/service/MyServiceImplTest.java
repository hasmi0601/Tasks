package com.example.springboottask.service;

import com.example.springboottask.Constants;
import com.example.springboottask.ErrorResponse;
import com.example.springboottask.controller.TaskController;
import com.example.springboottask.repository.MyRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MyServiceImplTest {

    private MyRepo myRepo=mock(MyRepo.class);
    private MyServiceImpl myService=new MyServiceImpl(myRepo);


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
            "                    \"name\": \"ADDRESS_STREET1\",\n" +
            "                    \"value\": \"ADDRESS_STREET1\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"ADDRESS_CITY\",\n" +
            "                    \"value\": \"ADDRESS_CITY\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"ADDRESS_STATE\",\n" +
            "                    \"value\": \"ADDRESS_STATE\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"ADDRESS_POSTALCODE\",\n" +
            "                    \"value\": \"ADDRESS_POSTALCODE\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"NAME_FIRST\",\n" +
            "                    \"value\": \"NAME_FIRST\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"NAME_LAST\",\n" +
            "                    \"value\": \"NAME_LAST\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"PHONE_NUMBER\",\n" +
            "                    \"value\": null\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"EMAIL_ADDRESS\",\n" +
            "                    \"value\": \"EMAIL_ADDRESS\"\n" +
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
            "                    \"name\": \"UNIQUE_ID\",\n" +
            "                    \"value\": \"ADDRESS_STREET1\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"ADDRESS_STREET1\",\n" +
            "                    \"value\": \"ADDRESS_STREET1\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"ADDRESS_CITY\",\n" +
            "                    \"value\": \"ADDRESS_CITY\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"ADDRESS_STATE\",\n" +
            "                    \"value\": \"ADDRESS_STATE\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"ADDRESS_POSTALCODE\",\n" +
            "                    \"value\": \"ADDRESS_POSTALCODE\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"NAME_FIRST\",\n" +
            "                    \"value\": \"NAME_FIRST\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"NAME_LAST\",\n" +
            "                    \"value\": \"NAME_LAST\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"PHONE_NUMBER\",\n" +
            "                    \"value\": \"PHONE_NUMBER\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"EMAIL_ADDRESS\",\n" +
            "                    \"value\": \"EMAIL_ADDRESS\"\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    }\n" +
            "}";
    String json2="{\n" +
            "    \"actionType\": \"TRANSLATION_ID\",\n" +
            "    \"s3SourceLocation\": \"s3a://venice-dev/test_1m_recs/sample_input_1000/\",\n" +
            "    \"s3TargetLocation\": \"s4://venice-dev/test_1m_recs/sample_output_1000/ \",\n" +
            "    \"jobProperties\": {\n" +
            "        \"assignmentJobProperties\": {\n" +
            "            \"fieldMappings\": [\n" +
            "                {\n" +
            "                    \"name\": \"UNIQUE_ID\",\n" +
            "                    \"value\": \"ADDRESS_STREET1\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"ADDRESS_STREET1\",\n" +
            "                    \"value\": \"ADDRESS_STREET1\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"ADDRESS_CITY\",\n" +
            "                    \"value\": \"ADDRESS_CITY\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"ADDRESS_STATE\",\n" +
            "                    \"value\": \"ADDRESS_STATE\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"ADDRESS_POSTALCODE\",\n" +
            "                    \"value\": \"ADDRESS_POSTALCODE\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"NAME_FIRST\",\n" +
            "                    \"value\": \"NAME_FIRST\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"NAME_LAST\",\n" +
            "                    \"value\": \"NAME_LAST\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"PHONE_NUMBER\",\n" +
            "                    \"value\": \"PHONE_NUMBER\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"EMAIL_ADDRESS\",\n" +
            "                    \"value\": \"EMAIL_ADDRESS\"\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    }\n" +
            "}";
    String json3="{\n" +
            "    \"actionType\": \"ID_ASSIGNMENT\",\n" +
            "    \"s3SourceLocation\": \"s3a://venice-dev/test_1m_recs/sample_input_1000/\",\n" +
            "    \"s3TargetLocation\": \"s4://venice-dev/test_1m_recs/sample_output_1000/\",\n" +
            "    \"jobProperties\": {\n" +
            "        \"assignmentJobProperties\": {\n" +
            "            \"fieldMappings\": [\n" +
            "                {\n" +
            "                    \"name\": \"UNIQUE_ID\",\n" +
            "                    \"value\": \"ADDRESS_STREET1\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"ADDRESS_STREET1\",\n" +
            "                    \"value\": \"ADDRESS_STREET1\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"ADDRESS_CITY\",\n" +
            "                    \"value\": \"ADDRESS_CITY\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"ADDRESS_STATE\",\n" +
            "                    \"value\": \"ADDRESS_STATE\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"ADDRESS_POSTALCODE\",\n" +
            "                    \"value\": \"ADDRESS_POSTALCODE\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"NAME_FIRST\",\n" +
            "                    \"value\": \"NAME_FIRST\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"NAME_LAST\",\n" +
            "                    \"value\": \"NAME_LAST\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"PHONE_NUMBER\",\n" +
            "                    \"value\": \"PHONE_NUMBER\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"EMAIL_ADDRESS\",\n" +
            "                    \"value\": \"EMAIL_ADDRESS\"\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    }\n" +
            "}";
    String json4="{\n" +
            "    \"actionType\": \"ID_ASSIGNMENT\",\n" +
            "    \"s3SourceLocation\": \"s3a://venice-dev/test_1m_recs/sample_input_1000/\",\n" +
            "    \"s3TargetLocation\": \"s3a://venice-dev/test_1m_recs/venice_output_loose_scrub/output_dataset/\",\n" +
            "    \"jobProperties\":null\n" +
            "}";
    String json5="{\n" +
            "    \"actionType\": \"ID_ASSIGNMENT\",\n" +
            "    \"s3SourceLocation\": \"s3a://venice-dev/test_1m_recs/sample_input_1000/\",\n" +
            "    \"s3TargetLocation\": \"s3a://venice-dev/test_1m_recs/venice_output_loose_scrub/output_dataset/\",\n" +
            "    \"jobProperties\": {\n" +
            "        \"assignmentJobProperties\": {}\n" +
            " }\n" +
            "}\n" +
            " \n";
    Constants constants=new Constants();


    @Test
    void shouldPassIfValidationIsTrue() throws JsonProcessingException {
        ResponseEntity responseEntity=taskController.postData(json1);
        ErrorResponse errorResponse=(ErrorResponse) responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        System.out.println(errorResponse.getMessage());
    }
    @Test
    void shouldPassIfValidationIsFalse() throws JsonProcessingException {
        ResponseEntity responseEntity=taskController.postData(json);
        ErrorResponse errorResponse=(ErrorResponse) responseEntity.getBody();
        assertEquals(HttpStatus.NOT_IMPLEMENTED,responseEntity.getStatusCode());
        System.out.println(errorResponse.getMessage());
    }
    @Test
    void shouldReturnNotImplementedWhenMandatoryFieldsAreMissing() throws JsonProcessingException {
        ResponseEntity responseEntity=taskController.postData(json);
        ErrorResponse errorResponse=(ErrorResponse) responseEntity.getBody();
        assertEquals(HttpStatus.NOT_IMPLEMENTED,responseEntity.getStatusCode());
        System.out.println(errorResponse.getMessage());

    }
    @Test
    void shouldReturnNotImplementedIfAnyValueIsNull() throws JsonProcessingException {
        ResponseEntity responseEntity=taskController.postData(json);
        ErrorResponse errorResponse=(ErrorResponse) responseEntity.getBody();
        assertTrue(errorResponse.getMessage().toString().contains("is null"));
        assertEquals(HttpStatus.NOT_IMPLEMENTED,responseEntity.getStatusCode());
        System.out.println(errorResponse.getMessage());
    }
    @Test
    void shouldReturnNotImplementedWhenSourceIsNull() throws JsonProcessingException {
        ResponseEntity responseEntity=taskController.postData(json);
        ErrorResponse errorResponse=(ErrorResponse) responseEntity.getBody();
        assertEquals(HttpStatus.NOT_IMPLEMENTED,responseEntity.getStatusCode());
        assertTrue(errorResponse.getMessage().toString().contains(constants.source));
        System.out.println(errorResponse.getMessage());

    }
    @Test
    void shouldReturnNotImplementedWhenTargetIsNull() throws JsonProcessingException{
        ResponseEntity responseEntity=taskController.postData(json3);
        ErrorResponse errorResponse=(ErrorResponse) responseEntity.getBody();
        assertEquals(HttpStatus.NOT_IMPLEMENTED,responseEntity.getStatusCode());
        System.out.println(errorResponse.getMessage());

    }
    @Test
    void shouldReturnNotImplementedWhenActionTypeIsTranslationId() throws JsonProcessingException{
        ResponseEntity responseEntity=taskController.postData(json2);
        ErrorResponse errorResponse=(ErrorResponse) responseEntity.getBody();
        assertTrue(errorResponse.getMessage().toString().contains(constants.translation));

    }
    @Test
    void shouldReturnNotImplementedWhenActionTypeMismatch() throws JsonProcessingException{
        ResponseEntity responseEntity=taskController.postData(json2);
        ErrorResponse errorResponse=(ErrorResponse) responseEntity.getBody();
        assertEquals(HttpStatus.NOT_IMPLEMENTED,responseEntity.getStatusCode());
        assertTrue(errorResponse.getMessage().toString().contains(constants.mismatch));
        System.out.println(errorResponse.getMessage());

    }
    @Test
    void shouldReturnNotImplementedWhenActionTypeIsWrong() throws JsonProcessingException{
        ResponseEntity responseEntity=taskController.postData(json3);
        ErrorResponse errorResponse=(ErrorResponse) responseEntity.getBody();
        assertEquals(HttpStatus.NOT_IMPLEMENTED,responseEntity.getStatusCode());
        System.out.println(errorResponse.getMessage());
    }
    @Test
    void shouldReturnNotImplementedWhenSourcePathIsNotCorrect() throws JsonProcessingException{
        ResponseEntity responseEntity=taskController.postData(json3);
        ErrorResponse errorResponse=(ErrorResponse) responseEntity.getBody();
        assertEquals(HttpStatus.NOT_IMPLEMENTED,responseEntity.getStatusCode());
        System.out.println(errorResponse.getMessage());
    }
    @Test
    void shouldReturnNotImplementedWhenTargetIsNotCorrect() throws JsonProcessingException{
        ResponseEntity responseEntity=taskController.postData(json3);
        ErrorResponse errorResponse=(ErrorResponse) responseEntity.getBody();
        assertEquals(HttpStatus.NOT_IMPLEMENTED,responseEntity.getStatusCode());
        System.out.println(errorResponse.getMessage());
    }
    String json6="{\n" +
            "    \"actionType\": \"ID_ASSIGNMENT\",\n" +
            "    \"s3SourceLocation\": \"s3a://venice-dev/test_1m_recs/sample_input_1000/\",\n" +
            "    \"s3TargetLocation\": \"s3a://venice-dev/test_1m_recs/venice_output_loose_scrub/output_dataset/\",\n" +
            "    \"jobProperties\": {\n" +
            "        \"assignmentJobProperties\": {\n" +
            "            \"fieldMappings\": null\n" +
            "        }\n" +
            "    }\n" +
            "}\n" +
            " \n";
    @Test
    void shouldReturnNotImplementedWhenJobPropertiesIsNull() throws JsonProcessingException {
        ResponseEntity responseEntity=taskController.postData(json4);
        ErrorResponse errorResponse=(ErrorResponse) responseEntity.getBody();
        assertEquals(HttpStatus.NOT_IMPLEMENTED,responseEntity.getStatusCode());
        System.out.println(errorResponse.getMessage());
    }
    @Test
    void shouldReturnNotImplementedWhenAssignmentJobPropertiesIsNull() throws JsonProcessingException{
        ResponseEntity responseEntity=taskController.postData(json5);
        ErrorResponse errorResponse=(ErrorResponse) responseEntity.getBody();
        assertEquals(HttpStatus.NOT_IMPLEMENTED,responseEntity.getStatusCode());
        System.out.println(errorResponse.getMessage());
    }
    @Test
    void shouldReturnNotImplementedWhenFieldMappingsIsNull() throws JsonProcessingException{
        ResponseEntity responseEntity=taskController.postData(json6);
        ErrorResponse errorResponse=(ErrorResponse) responseEntity.getBody();
        assertEquals(HttpStatus.NOT_IMPLEMENTED,responseEntity.getStatusCode());
        System.out.println(errorResponse.getMessage());
    }

}