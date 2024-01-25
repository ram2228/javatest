package com.imaginnovate.employee.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
/*

 * Phone number validation
 * Created on 25-01-2024
 * By Ramakrishna P
 */
public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, Long> {

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		String longValue = String.valueOf(value.longValue());
		if (value.longValue() > 0 && !longValue.startsWith("0") && longValue.length() == 10) {
			return true;
		}
		return false;
	}

}
