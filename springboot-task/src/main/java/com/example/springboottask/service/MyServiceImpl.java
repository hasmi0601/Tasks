package com.example.springboottask.service;

import com.example.springboottask.Constants;
import com.example.springboottask.DataValidation;
import com.example.springboottask.ErrorResponse;
import com.example.springboottask.entity.Details;
import com.example.springboottask.repository.MyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService{
    Constants constant=new Constants();
    @Autowired
    private MyRepo myRepo;

    public MyServiceImpl(){};
    public MyServiceImpl(MyRepo myRepo){
        this.myRepo=myRepo;
    }
    @Override
    public ResponseEntity postData(DataValidation validate_obj, Details details) {
        if(validate_obj.isValid()){
            ErrorResponse errorResponse=new ErrorResponse(constant.ok,validate_obj.getError_response());
            myRepo.save(details);
            return new ResponseEntity(errorResponse,HttpStatus.OK);
        }
        ErrorResponse errorResponse=new ErrorResponse(constant.not_implemented,validate_obj.getError_response());
        return new ResponseEntity(errorResponse,HttpStatus.NOT_IMPLEMENTED);
    }
}
