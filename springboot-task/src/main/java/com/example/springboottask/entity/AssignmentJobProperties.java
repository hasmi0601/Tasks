package com.example.springboottask.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.List;

@JsonTypeName("assignmentJobProperties")
public class AssignmentJobProperties implements JobProperties{
    @JsonProperty("fieldMappings")
    private List<Store> fieldMappings;

//    public AssignmentJobProperties(){}
//    public AssignmentJobProperties(List<Store> fieldMappings) {
//        this.fieldMappings = fieldMappings;
//    }

    public List<Store> getFieldMappings() {
        return fieldMappings;
    }

    public void setFieldMappings(List<Store> fieldMappings) {
        this.fieldMappings = fieldMappings;
    }

    @Override
    public String toString() {
        return "AssignmentJobProperties{" +
                "fieldMappings=" + fieldMappings +
                '}';
    }
}
