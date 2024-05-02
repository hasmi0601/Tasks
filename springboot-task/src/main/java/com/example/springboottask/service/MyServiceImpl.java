package com.example.springboottask.service;

import com.example.springboottask.Constants1;
import com.example.springboottask.DataValidation;
import com.example.springboottask.Enums1;
import com.example.springboottask.ErrorResponse;
import com.example.springboottask.entity.AssignmentJobProperties;
import com.example.springboottask.entity.Details;
import com.example.springboottask.entity.Store;
import com.example.springboottask.entity.TranslationJobProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.validation.Validator;
import java.util.ArrayList;
import java.util.List;

import static com.example.springboottask.Enums1.UNIQUE_ID;
import static com.example.springboottask.Enums1.values;
import static com.example.springboottask.ValidationCheck.validation;

@Service
public class MyServiceImpl implements MyService{

//    @Autowired
//    private DataValidation dataValidation;
//    public MyServiceImpl(DataValidation dataValidation){
//        this.dataValidation=dataValidation;
//    }

    @Override
    public ResponseEntity postData(Details details) {
        DataValidation validate_obj= validation(details);
        if(validate_obj.isValid()){
            ErrorResponse errorResponse=new ErrorResponse(HttpStatus.OK,validate_obj.getError_response());
            return new ResponseEntity(errorResponse,HttpStatus.OK);
        }
        ErrorResponse errorResponse=new ErrorResponse(HttpStatus.NOT_IMPLEMENTED,validate_obj.getError_response());
        return new ResponseEntity(errorResponse,HttpStatus.NOT_IMPLEMENTED);
    }
}
