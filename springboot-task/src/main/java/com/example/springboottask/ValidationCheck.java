package com.example.springboottask;

import com.example.springboottask.entity.AssignmentJobProperties;
import com.example.springboottask.entity.Details;
import com.example.springboottask.entity.Store;

import java.util.ArrayList;
import java.util.List;

import static com.example.springboottask.Enums1.values;

public class ValidationCheck {
    static Constants1 constant;
    static boolean isValid;

    public static DataValidation validation(Details details) {
        constant = new Constants1();
        isValid = true;
            sourceAndTargetCheck(details);
            if (translationIdCheck(details)) {
                return new DataValidation(isValid, constant.tid);
            }
            mandatoryFieldAndNullCheck(details);
            if (constant.final_error.isEmpty()) {
                return new DataValidation(isValid, constant.no_error);
            }
        else{

        }
        return new DataValidation(isValid, constant.final_error);
    }

    public static void sourceAndTargetCheck(Details details) {
        if (details.getS3SourceLocation() == null) {
            constant.error_msg.append(constant.source).append(" ");
        }
        if (details.getS3TargetLocation() == null) {
            if(!constant.error_msg.isEmpty()){
                constant.error_msg.append(" ");
            }
            constant.error_msg.append(constant.target);

        }
        if (!constant.error_msg.isEmpty()) {
            constant.error_msg.append(constant.valueisnull);
        }

        constant.final_error.append(constant.error_msg);
        constant.error_msg = new StringBuilder();
    }

    public static boolean translationIdCheck(Details details) {
        if (details.getActionType().equals(constant.TRANSLATION_ID)) {
            constant.tid.append(constant.translation).append(" ");
            if (details.getJobProperties() instanceof AssignmentJobProperties)
                constant.tid.append(constant.mismatch);
            isValid = false;
            return true;
            //errorResponse=new ErrorResponse(HttpStatus.NOT_IMPLEMENTED,constant.tid);
            //return new ResponseEntity<>(errorResponse,HttpStatus.NOT_IMPLEMENTED);
        }
        return false;
    }

    public static void mandatoryFieldAndNullCheck(Details details) {
        findFieldsAndNullValues(details);
        if (!constant.missing.isEmpty()) {
            constant.missing.append(constant.fieldismissing);
            constant.error_msg.append(constant.missing);
        }
        if (!constant.nullvalues.isEmpty()) {
            if(!constant.missing.isEmpty()){
                constant.error_msg.append(" ");
            }
            constant.nullvalues.append(constant.valueisnull);
            constant.error_msg.append((constant.nullvalues));
        }

        if (!constant.error_msg.isEmpty()) {
            constant.final_error.append(" "+constant.error_msg);
        }

        if (!constant.final_error.isEmpty()) {
            isValid = false;
            //errorResponse=new ErrorResponse(HttpStatus.NOT_IMPLEMENTED,constant.final_error);
            //return new ResponseEntity<>(errorResponse,HttpStatus.NOT_IMPLEMENTED);
        }
    }


    public static void findFieldsAndNullValues(Details details) {
        if (details.getJobProperties() instanceof AssignmentJobProperties) {
            List<Store> fieldMappingList = ((AssignmentJobProperties) details.getJobProperties()).getFieldMappings();
            ArrayList<String> fieldsPresent = new ArrayList<>();
            for (Store eachField : fieldMappingList) {
                fieldsPresent.add(eachField.getName());
            }
            for (Enums1 field : values()) {
                if (field.isRequired) {
                    if (!fieldsPresent.contains(field.toString())) {
                        constant.missing.append(field.toString()).append(" ");
                    }
                    for (Store eachField : fieldMappingList) {
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
}
