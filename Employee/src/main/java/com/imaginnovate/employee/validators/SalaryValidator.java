package com.imaginnovate.employee.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SalaryValidator implements ConstraintValidator<ValidSalary, Double> {

	@Override
	public boolean isValid(Double value, ConstraintValidatorContext context) {
		String salValue = String.valueOf(value.doubleValue());
		String salWithoutPrecision = salValue.substring(0, salValue.indexOf("."));
		String precision = salValue.substring(salValue.indexOf(".")+1, salValue.length());
		if (value.doubleValue() > 0 && 
				salWithoutPrecision.length() >= 4 && 
				salWithoutPrecision.length() <= 10 && 
				precision.length() <= 2) {
			return true;
		}
		return false;
	}

}
