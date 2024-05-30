package com.example.springboottask;

/**
 * This class contains all the constants that are used in the project.
 * @author phreddy
 */
public class Constants {
    public String source="s3SourceLocation",target="s3TargetLocation";
    public StringBuilder error_msg=new StringBuilder();
    public StringBuilder no_error=new StringBuilder("No Error");
    public StringBuilder missing=new StringBuilder();
    public StringBuilder nullvalues=new StringBuilder();
    public StringBuilder tid=new StringBuilder();
    public StringBuilder final_error=new StringBuilder();
    public String valueisnull="is null";
    public String fieldismissing="is missing";
    public String TRANSLATION_ID="TRANSLATION_ID";
    public String translation="TRANSLATION_ID is not supported";
    public String mismatch="Action type and job properties mismatch";
    public String ID_ASSIGNMENT="ID_ASSIGNMENT";
    public StringBuilder patterncheck=new StringBuilder();
    public String actionTypeNotSupported="ActionType is not supported";
    public String comma=",";
    public String sourcePathMismatch="s3SourceLocation path doesn't match the pattern";
    public String targetPathMismatch="s3SourceLocation path doesn't match the pattern";
    public String bucket="s3a";
    public String missingFieldsTrimmed, missingFields;
    public String nullValuesTrimmed, nullValuesPresent;
    public String jobPropertiesNull="Job properties is null";
    public String ok="200 OK";
    public String not_implemented="501 NOT_IMPLEMENTED";
}
