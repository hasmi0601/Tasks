package com.example.springboottask.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class FieldMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("value")
    private String value1;


    /**
     * This is to get the name of the field from the request
     * @return name of the field given in the request
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value to the new field
     * @param name new field to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This is to get the value of the field from the request
     * @return value of the field
     */
    public String getValue1() {
        return value1;
    }

    /**
     * This is to set the value of the field to new value
     * @param value1 new value to be set to the field
     */
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
