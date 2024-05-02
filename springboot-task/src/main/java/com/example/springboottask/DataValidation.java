package com.example.springboottask;

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
