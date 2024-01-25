package com.imaginnovate.employee.util;


import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

/*

 * Employee Util to maintain static variable for constants and messages
 * Created on 25-01-2024
 * By Ramakrishna P
 */
public class EmployeeConstant {

	public final static DateTimeFormatter DD_MM_YYYY = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	public final static DateTimeFormatter DD_MM_YYYY_T_HH_MM_SS = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm:ss");
	
	public final static DecimalFormat ZERO_DECIMAL = new DecimalFormat("#"); 
	
	public final static int LOSS_OF_PAY_PER_DAY = 30;
	
	public final static int CESS_TAX_AMOUNT = 2500000;
	public final static int CESS_TAX_PERCENTAGE = 2;
	
	
	public final static String Employee_NOT_FOUND = "Employee is not found";	
	
	//invalid data error messages 
	public final static String INVALID_INPUT = "Invalid input, please check the data";
	public final static String UNIQUE_EMAIL = "email is already exist";
	public final static String UNIQUE_PHONE_NUMBER = "phone number is already exist";
}
