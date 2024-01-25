package com.imaginnovate.employee.validators;

import java.time.LocalDate;

import com.imaginnovate.employee.util.EmployeeConstant;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
/*

 * Date validation
 * Created on 25-01-2024
 * By Ramakrishna P
 */
public class DateValidator implements ConstraintValidator<ValidDate, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {	
		try {
			LocalDate.parse(value, EmployeeConstant.DD_MM_YYYY);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
