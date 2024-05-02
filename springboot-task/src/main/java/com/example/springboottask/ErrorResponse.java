package com.example.springboottask;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
    private HttpStatus code;
    private StringBuilder message;
    public ErrorResponse(){}

    public ErrorResponse(HttpStatus code, StringBuilder message) {
        this.code = code;
        this.message = message;
    }

    public HttpStatus getCode() {
        return code;
    }

    public void setCode(HttpStatus code) {
        this.code = code;
    }

    public StringBuilder getMessage() {
        return message;
    }

    public void setMessage(StringBuilder message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "code=" + code +
                ", message=" + message +
                '}';
    }
}
