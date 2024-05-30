package com.example.springboottask.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.*;

import java.util.List;

/**
 * This class is to declare the list of (name,value) pairs which consists of the fields and their values.
 * It includes the getter and setter methods as well
 *
 * @author phreddy
 */

@Entity
@JsonTypeName("assignmentJobProperties")
@DiscriminatorValue("ASSIGNMENT")
public class AssignmentJobProperties extends JobProperties {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonProperty("fieldMappings")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "assignmentJobPropertiesId")
    private List<FieldMapping> fieldMappings;


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
        return "AssignmentJobProperties{" +
                "fieldMappings=" + fieldMappings +
                '}';
    }
}
