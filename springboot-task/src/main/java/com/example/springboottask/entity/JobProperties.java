package com.example.springboottask.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AssignmentJobProperties.class),
        @JsonSubTypes.Type(value = TranslationJobProperties.class)
})
public interface JobProperties {
//    public List<Store> getFieldMappings();
//    public void setFieldMappings(List<Store> fieldMappings);
}
