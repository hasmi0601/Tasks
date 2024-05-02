package com.example.springboottask.service;

import com.example.springboottask.entity.Details;
import org.springframework.http.ResponseEntity;

public interface MyService {
    public ResponseEntity postData(Details details);
}
