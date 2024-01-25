package com.imaginnovate.employee.exception;

/*

 * Employee exception not found
 * Created on 23-01-2024
 * By Ramakrishna P
 */
public class EmployeeNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
