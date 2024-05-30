package com.example.springboottask.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

/**
 * This class consists of the attributes of the data like actionType, s3SourceLocation, s3TargetLocation,
 * jobProperties and their getter and setter methods
 *
 * @author phreddy
 */
@Entity
public class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonProperty("actionType")
    private String actionType;
    @JsonProperty("s3SourceLocation")
    private String s3SourceLocation;
    @JsonProperty("s3TargetLocation")
    private String s3TargetLocation;
    @JsonProperty("jobProperties")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "JobPropertiesId")
    private JobProperties jobProperties;

    public Details(){}

    public Details(String actionType, String s3SourceLocation, String s3TargetLocation, JobProperties jobProperties) {
        this.actionType = actionType;
        this.s3SourceLocation = s3SourceLocation;
        this.s3TargetLocation = s3TargetLocation;
        this.jobProperties = jobProperties;
    }

    /**
     * This is to get the actionType from the request
     * @return actionType is returned
     */
    public String getActionType() {
        return actionType;
    }

    /**
     * This is to set the actionType as per the requirement
     * @param actionType new actionType that needs to be placed.
     */
    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    /**
     * This is to get the s3SourceLocation from the request
     * @return s3SourceLocation given in the request is returned
     */
    public String getS3SourceLocation() {
        return s3SourceLocation;
    }

    /**
     * This is to set the s3SourceLocation to the new value
     * @param s3SourceLocation new value of s3SourceLocation that needs to be placed
     */
    public void setS3SourceLocation(String s3SourceLocation) {
        this.s3SourceLocation = s3SourceLocation;
    }

    /**
     * This is to get the s3TargetLocation from the request
     * @return s3TargetLocation given in the request is returned
     */
    public String getS3TargetLocation() {
        return s3TargetLocation;
    }

    /**
     * This is to set the s3TargetLocation to the new value
     * @param s3TargetLocation new value of s3TargetLocation that needs to be placed
     */
    public void setS3TargetLocation(String s3TargetLocation) {
        this.s3TargetLocation = s3TargetLocation;
    }

    /**
     * This is to get the jobProperties given in the request
     * @return jobProperties from the request
     */
    public JobProperties getJobProperties() {
        return jobProperties;
    }

    /**
     * This is to set the jobProperties to the new value
     * @param jobProperties new jopProperties to be set
     */
    public void setJobProperties(JobProperties jobProperties) {
        this.jobProperties = jobProperties;
    }

    @Override
    public String toString() {
        return "Details{" +
                "actionType='" + actionType + '\'' +
                ", s3SourceLocation='" + s3SourceLocation + '\'' +
                ", s3TargetLocation='" + s3TargetLocation + '\'' +
                ", jobProperties=" + jobProperties +
                '}';
    }
}
