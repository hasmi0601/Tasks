package com.example.springboottask.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Store {
    @JsonProperty("name")
    private String name;
    @JsonProperty("value1")
    private String value1;

//    public Store(String name, String value1) {
//        this.name = name;
//        this.value1 = value1;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", value1='" + value1 + '\'' +
                '}';
    }
}
