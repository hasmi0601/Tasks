package com.example.springboottask;

import org.springframework.http.HttpStatus;

/**
 * ErrorResponse contains the httpStatus code and the message that needs to be returned. The code can be
 * OK for valid request or NOT_IMPLEMENTED for invalid request. The message has the particular error
 * for NOT_IMPLEMENTED and no error for OK.
 *
 * @author phreddy
 */
public class ErrorResponse {
    private String code;
    private StringBuilder message;
    public ErrorResponse(){}

    public ErrorResponse(String code, StringBuilder message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
