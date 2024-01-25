package com.imaginnovate.employee.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
/*

 * Employee join date validation
 * Created on 25-01-2024
 * By Ramakrishna P
 */
@Documented
@Target( { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateValidator.class)
public @interface ValidDate {
	String message() default "Date format must be dd-MM-yyyy.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
