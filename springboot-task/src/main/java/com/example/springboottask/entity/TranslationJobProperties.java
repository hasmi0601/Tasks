package com.example.springboottask.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.*;

import java.util.List;

/**
 * This class is to declare the list of (name,value) pairs which consists of the fields and their values.
 * It includes the getter and setter methods as well
 *
 * @author phreddy
 */

@JsonTypeName("translationJobProperties")
public class TranslationJobProperties extends JobProperties {
    private List<FieldMapping> fieldMappings;

    public TranslationJobProperties(){}

    public TranslationJobProperties(List<FieldMapping> fieldMappings) {
        this.fieldMappings = fieldMappings;
    }

    /**
     * This method to get the fieldMappings which is a list of name and value pairs.
     * @return List(name,value)
     */
    public List<FieldMapping> getFieldMappings() {
        return fieldMappings;
    }

    /**
     * This method is to set the new values of fieldMappings
     * @param fieldMappings new values of the fieldMappings
     */
    public void setFieldMappings(List<FieldMapping> fieldMappings) {
        this.fieldMappings = fieldMappings;
    }

    @Override
    public String toString() {
        return "TranslationJobProperties{" +
                "fieldMappings=" + fieldMappings +
                '}';
    }
}
