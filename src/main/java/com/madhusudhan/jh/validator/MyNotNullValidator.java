package com.madhusudhan.jh.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyNotNullValidator implements ConstraintValidator<MyNotNull, Object> {
    public void initialize(MyNotNull parameters) {
    }

    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        return object != null;
    }
}
