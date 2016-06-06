package com.madhusudhan.jh.validator;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = {MyNotNullValidator.class})
public @interface MyNotNull {
    String propertyName(); //Annotation Attribute Name
    String message() default "{myNotNull}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default {};
}
