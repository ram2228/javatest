package com.imaginnovate.employee.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
/*

 * Employee Salary validation
 * Created on 25-01-2024
 * By Ramakrishna P
 */
@Documented
@Target( { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SalaryValidator.class)
public @interface ValidSalary {
	String message() default "Salary must be between 4 and 10 digits and only 2 non-zero precision is allowed.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
