package com.example.springboottask;

public enum Enums1 {
    UNIQUE_ID(true),
    ADDRESS_STREET1(true),
    PHONE_NUMBER(true),
    EMAIL_ADDRESS(true),
    NAMES_FIRST(false),
    NAMES_LAST(false);
    public boolean isRequired;
    Enums1(boolean isRequired){
        this.isRequired=isRequired;
    }

}
