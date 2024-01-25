package com.imaginnovate.employee.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/*

 * Employee phone validation
 * Created on 25-01-2024
 * By Ramakrishna P
 */

@Documented
@Target( { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneNumberValidator.class)
public @interface ValidPhoneNumber {
	String message() default "PhoneNumber must be 10 digits and should be start with non-zero value";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
