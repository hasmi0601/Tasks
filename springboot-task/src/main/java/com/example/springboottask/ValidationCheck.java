package com.example.springboottask;

import com.example.springboottask.entity.AssignmentJobProperties;
import com.example.springboottask.entity.Details;
import com.example.springboottask.entity.FieldMapping;
import com.example.springboottask.entity.TranslationJobProperties;

import java.util.ArrayList;
import java.util.List;

import static com.example.springboottask.Fields.values;

/**
 * This is for performing validation on the post request.
 *
 * @author phreddy
 */
public class ValidationCheck {
    static Constants constant;
    static boolean isValid;

    /**+
     *This is main method for the validation check which includes the sub methods. Here the validation
     * for s3SourceLocation and s3TargetLocation, checking the mandatory fields and their values, is done.
     * The check for TRANSLATION_ID and action type and job properties mismatched is also validated.
     * Action type can have only two values, checking the mismatch of action type is also covered.
     * If the data provided is valid then the httpsStatusCode is returned as OK, else it is NOT_IMPLEMENTED.
     *
     * @param details consists of actionType, s3SourceLocation, s3TargetLocation, jobProperties-
     *                assignmentJobProperties or translationJobProperties- fieldMappings- List({name,value})
     * @return dataValidation object that contains the statusCode and message
     */
    public static DataValidation validation(Details details) {
        constant = new Constants();
        isValid = true;
        if(details.getActionType().equals(constant.ID_ASSIGNMENT)) {
            sourceAndTargetCheck(details);
            mandatoryFieldAndNullCheck(details);
            String message=constant.final_error.toString().trim();
            StringBuilder errorMessage=new StringBuilder(message);
            if (errorMessage.isEmpty()) {
                isValid=true;
                return new DataValidation(isValid, constant.no_error);
            }
        }
        else if (translationIdCheck(details)) {
            return new DataValidation(isValid, constant.tid);
        }
        else if(!details.getActionType().equals(constant.translation) || !details.getActionType().equals(constant.ID_ASSIGNMENT)){
            isValid=false;
            constant.final_error.append(constant.actionTypeNotSupported);
            return new DataValidation(isValid,constant.final_error);
        }
        String message=constant.final_error.toString().trim();
        StringBuilder errorMessage=new StringBuilder(message);
        return new DataValidation(isValid,errorMessage);
    }

    /**+
     * This method is used to check whether the s3SourceLocation or s3TargetLocation is null. It also checks
     * the pattern of both i.e. it should start with s3a. If any of the locations is null or don't match the
     * pattern, then statusCode is returned as NOT_IMPLEMENTED with the respective error_message.
     *
     * @param details consists of actionType, s3SourceLocation, s3TargetLocation, jobProperties-
     *        assignmentJobProperties or translationJobProperties- fieldMappings- List({name,value})
     */
    public static void sourceAndTargetCheck(Details details) {
        if (details.getS3SourceLocation() == null) {
            constant.error_msg.append(constant.source);
        }
        if (details.getS3TargetLocation() == null) {
            if(!constant.error_msg.isEmpty()){
                constant.error_msg.append(constant.comma);
            }
            constant.error_msg.append(constant.target);

        }
        if(details.getS3SourceLocation()!=null){
            String[] path=details.getS3SourceLocation().split("://");
            if(path.length==0 || !path[0].equals(constant.bucket)){
                if(!constant.patterncheck.isEmpty() || !constant.error_msg.isEmpty())
                    constant.patterncheck.append(constant.comma);
                constant.patterncheck.append(constant.sourcePathMismatch);
            }
        }

        if(details.getS3TargetLocation()!=null){
            String[] TargetPath=details.getS3TargetLocation().split("://");
            if(TargetPath.length==0 || !TargetPath[0].equals(constant.bucket)){
                if(!constant.patterncheck.isEmpty() || !constant.error_msg.isEmpty())
                    constant.patterncheck.append(constant.comma);
                constant.patterncheck.append(constant.targetPathMismatch);
            }
        }
        if (!constant.error_msg.isEmpty()) {
            constant.error_msg.append(" "+constant.valueisnull);
        }
        constant.final_error.append(constant.error_msg);
        constant.final_error.append(constant.patterncheck);
        if(!constant.final_error.isEmpty()){
            isValid=false;
        }
        constant.error_msg = new StringBuilder();
    }

    /**+
     * This is method is to check whether the actionType is TRANSLATION_ID or not. If the actionType is
     * TRANSLATION_ID then further checking is done on the jobProperties,else false is returned
     * along with updating the error message. If the jobProperties is assignment, mismatch error is
     * appended to the error message.
     * @param details consists of actionType, s3SourceLocation, s3TargetLocation, jobProperties-
     *        assignmentJobProperties or translationJobProperties- fieldMappings- List({name,value})
     * @return True if actionType is TRANSLATION_ID else false
     */
    public static boolean translationIdCheck(Details details) {
        if (details.getActionType().equals(constant.TRANSLATION_ID)) {
            constant.tid.append(constant.translation);
            if (details.getJobProperties() instanceof AssignmentJobProperties)
                constant.tid.append(constant.comma+constant.mismatch);
            isValid = false;
            return true;
        }
        return false;
    }

    /**+
     * This method consists of sub methods which are used for checking the mandatory fields and null values of
     * those fields. The error message is updated as per the requirement.
     * @param details consists of actionType, s3SourceLocation, s3TargetLocation, jobProperties-
     *        assignmentJobProperties or translationJobProperties- fieldMappings- List({name,value})
     */
    public static void mandatoryFieldAndNullCheck(Details details) {
        findFieldsAndNullValues(details);
        formatMissingAndNullValues();

        if (!constant.error_msg.isEmpty()) {
            constant.final_error.append(constant.error_msg);
        }

        if (!constant.final_error.isEmpty()) {
            isValid = false;
        }
    }

    /**+
     * This is the method to trim the error message and insert commas.
     */
    public static void formatMissingAndNullValues(){
        if(!constant.target.isEmpty()||!constant.source.isEmpty()||!constant.patterncheck.isEmpty())
            constant.error_msg.append(" ");
        constant.missingFieldsTrimmed=constant.missing.toString().trim();
        constant.missingFields=constant.missingFieldsTrimmed.replace(' ',',');
        StringBuilder finalFieldsMissing=new StringBuilder(constant.missingFields);
        if (!constant.missing.isEmpty()) {
            finalFieldsMissing.append(" "+constant.fieldismissing);
            constant.error_msg.append(finalFieldsMissing);
        }
        constant.nullValuesTrimmed=constant.nullvalues.toString().trim();
        constant.nullValuesPresent=constant.nullValuesTrimmed.replace(' ',',');
        StringBuilder finalNullValues=new StringBuilder(constant.nullValuesPresent);
        if (!constant.nullvalues.isEmpty()) {
            if(!constant.missing.isEmpty()){
                constant.error_msg.append(" ");
            }
            finalNullValues.append(" "+constant.valueisnull);
            constant.error_msg.append(finalNullValues);
        }
    }

    /**+
     * This is the method to find whether the post request consists of mandatory fields or not.
     * If they are mandatory fields then further checking is done on their values, else error message is
     * updated with the particular mandatory fields that are missing. The values of the mandatory fields
     * should not be null. If null, then error message is updated that the values of particular fields are null.
     * The above check is done if the jobProperties is an instance of assignmentJobProperties. If it is an
     * instance of translationJobProperties then no check is required, instead the mismatch is specified.
     * If jobProperties is null then the error message is updated with jobProperties is null.
     *
     * @param details consists of actionType, s3SourceLocation, s3TargetLocation, jobProperties-
     *        assignmentJobProperties or translationJobProperties- fieldMappings- List({name,value})
     */
    public static void findFieldsAndNullValues(Details details) {
        if (details.getJobProperties() instanceof AssignmentJobProperties) {
            if(((AssignmentJobProperties) details.getJobProperties()).getFieldMappings()==null){
                   for(Fields field:values()){
                       if(field.isRequired){
                           constant.missing.append(field.toString()).append(" ");
                       }
                   }
            }
            else {
                List<FieldMapping> fieldMappingList = ((AssignmentJobProperties) details.getJobProperties()).getFieldMappings();
                ArrayList<String> fieldsPresent = new ArrayList<>();
                fieldMappingList.forEach(eachField->fieldsPresent.add(eachField.getName()));
                for (Fields field : values()) {
                    if (field.isRequired) {
                        if (!fieldsPresent.contains(field.toString())) {
                            constant.missing.append(field.toString()).append(" ");
                        }
                        for (FieldMapping eachField : fieldMappingList) {
                            if (eachField.getName().equals(field.toString())) {
                                if (eachField.getValue1() == null) {
                                    constant.nullvalues.append(eachField.getName()).append(" ");
                                }
                            }
                        }
                    }
                }
            }
        }
        else if(details.getJobProperties() instanceof TranslationJobProperties){
            constant.final_error.append(" "+constant.mismatch);
        }
        else{
            if(!constant.final_error.isEmpty()){
                constant.final_error.append(" ");
            }
            constant.final_error.append(constant.jobPropertiesNull);
        }
    }
}
