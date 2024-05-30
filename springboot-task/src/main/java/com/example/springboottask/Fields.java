package com.example.springboottask;

/**
 * This is to set the fields as mandatory and non-mandatory
 * @author phreddy
 */
public enum Fields {
    /**
     * UNIQUE_ID is a mandatory field.
     */
    UNIQUE_ID(true),
    /**
     * ADDRESS_STREET1 is a mandatory field.
     */
    ADDRESS_STREET1(true),
    /**
     * PHONE_NUMBER is a mandatory field.
     */
    PHONE_NUMBER(true),
    /**
     * EMAIL_ADDRESS is a mandatory field.
     */
    EMAIL_ADDRESS(true),
    /**
     * NAMES_FIRST is not a mandatory field.
     */
    NAMES_FIRST(false),
    /**
     * NAMES_LAST is not a mandatory field.
     */
    NAMES_LAST(false);
    /**
     * If isRequired is true then the field is mandatory else the field is not mandatory.
     */
    public boolean isRequired;

    /**
     * Sets the isRequired value for each field.
     * @param isRequired is true for mandatory field, false for non-mandatory field
     */
    Fields(boolean isRequired){
        this.isRequired=isRequired;
    }

}
