package com.ipze.self_assessment.security.config.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NullOrNotBlankValidator implements ConstraintValidator<NullOrNotBlank, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        String str = (String) value;
        if (str == null) {
            return true;
        }
        return str.trim().length() > 0;
    }
}
