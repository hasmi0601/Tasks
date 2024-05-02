package com.example.springboottask.controller;

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

@RestController
public class TaskController {
    private ObjectMapper objectMapper=new ObjectMapper();
    @Autowired
    private MyService myService;

    public TaskController(MyService myService){
        this.myService=myService;
    }

    @GetMapping("/")
    public String printing(){
        return "hello all";
    }

    @PostMapping("/details")
    public ResponseEntity postData(@Valid @RequestBody String json) throws JsonProcessingException {
        Details details=objectMapper.readValue(json,Details.class);
        return myService.postData(details);
    }
}
