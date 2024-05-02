package com.example.springboottask.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Details {
    @JsonProperty("actionType")
    private String actionType;
    @JsonProperty("s3SourceLocation")
    private String s3SourceLocation;
    @JsonProperty("s3TargetLocation")
    private String s3TargetLocation;
    @JsonProperty("jobProperties")
    private JobProperties jobProperties;

    public Details(){}

    public Details(String actionType, String s3SourceLocation, String s3TargetLocation, JobProperties jobProperties) {
        this.actionType = actionType;
        this.s3SourceLocation = s3SourceLocation;
        this.s3TargetLocation = s3TargetLocation;
        this.jobProperties = jobProperties;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getS3SourceLocation() {
        return s3SourceLocation;
    }

    public void setS3SourceLocation(String s3SourceLocation) {
        this.s3SourceLocation = s3SourceLocation;
    }

    public String getS3TargetLocation() {
        return s3TargetLocation;
    }

    public void setS3TargetLocation(String s3TargetLocation) {
        this.s3TargetLocation = s3TargetLocation;
    }

    public JobProperties getJobProperties() {
        return jobProperties;
    }

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
