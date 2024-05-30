package com.example.springboottask;

/**
 * This class consists of error_response that needs to be returned and isValid variable which tells whether the
 * request is correct without errors or not.
 * @author phreddy
 */
public class DataValidation {
    private boolean isValid;
    private StringBuilder error_response;

    public DataValidation(boolean isValid, StringBuilder error_response) {
        this.isValid = isValid;
        this.error_response = error_response;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public StringBuilder getError_response() {
        return error_response;
    }

    public void setError_response(StringBuilder error_response) {
        this.error_response = error_response;
    }
}
