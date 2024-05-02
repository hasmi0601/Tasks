package com.example.springboottask.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.List;

@JsonTypeName("translationJobProperties")
public class TranslationJobProperties implements JobProperties{
    private List<Store> fieldMappings;

    public TranslationJobProperties(){}

    public TranslationJobProperties(List<Store> fieldMappings) {
        this.fieldMappings = fieldMappings;
    }


    public List<Store> getFieldMappings() {
        return fieldMappings;
    }

    public void setFieldMappings(List<Store> fieldMappings) {
        this.fieldMappings = fieldMappings;
    }

    @Override
    public String toString() {
        return "TranslationJobProperties{" +
                "fieldMappings=" + fieldMappings +
                '}';
    }
}
