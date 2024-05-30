package com.example.springboottask.controller;

import com.example.springboottask.DataValidation;
import com.example.springboottask.entity.Details;
import com.example.springboottask.service.MyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.springboottask.ValidationCheck.validation;

/**
 * This is for writing the methods to take or send the request to the API
 * @author phreddy
 */
@RestController
public class TaskController {
    private ObjectMapper objectMapper=new ObjectMapper();
    @Autowired
    private MyService myService;

    public TaskController(MyService myService){
        this.myService=myService;
    }

//    @GetMapping("/")
//    public String printing(){
//        return "hello all";
//    }

    /**
     * This is the method that converts the given json into an object using object mapper. The validation is
     * performed on this request and is sent to service after validation.
     * @param json string that contains the post request
     * @return ResponseEntity which includes errorResponse and statusCode
     * @throws JsonProcessingException if json is not parsed properly
     */
    @PostMapping("/details")
    public ResponseEntity postData(@Valid @RequestBody String json) throws JsonProcessingException {
        Details details=objectMapper.readValue(json,Details.class);
        DataValidation validate_obj= validation(details);
        return myService.postData(validate_obj,details);
    }
}
