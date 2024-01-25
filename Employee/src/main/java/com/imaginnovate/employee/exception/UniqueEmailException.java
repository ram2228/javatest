package com.imaginnovate.employee.exception;
/*

 * Employee UniqueEmailException
 * Created on 23-01-2024
 * By Ramakrishna P
 */

public class UniqueEmailException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UniqueEmailException(String message) {
		super(message);
	}
}
