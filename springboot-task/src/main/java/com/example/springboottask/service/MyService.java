package com.example.springboottask.service;

import com.example.springboottask.DataValidation;
import com.example.springboottask.entity.Details;
import org.springframework.http.ResponseEntity;

public interface MyService {
    public ResponseEntity postData(DataValidation dataValidation, Details details);
}
