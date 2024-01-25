package com.imaginnovate.employee.exception;

/*

 * Employee UniquePhoneNumberException
 * Created on 23-01-2024
 * By Ramakrishna P
 */
public class UniquePhoneNumberException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UniquePhoneNumberException(String message) {
		super(message);
	}
}
