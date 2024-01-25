package com.imaginnovate.employee.dto;

import com.imaginnovate.employee.validators.ValidDate;
import com.imaginnovate.employee.validators.ValidPhoneNumber;
import com.imaginnovate.employee.validators.ValidSalary;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

/*

 * Dto and validation to validate employee data before processing it
 * Created 25-01-2024
 * By Ramakrishna P
 */
public class EmployeeDto {

	private int Id;
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@NotBlank(message = "The first name is required.")
	@Pattern(regexp = "[a-zA-Z]*", message = "The first name must contains alphabets only.")
	@Size(min = 3, max = 50, message = "The length of first name must be between 3 and 50 characters.")
	private String firstName;
	
	
	@NotBlank(message = "The last name is required.")
	@Pattern(regexp = "[a-zA-Z]*", message = "The last name must contains alphabets only.")
	@Size(min = 3, max = 50, message = "The length of last name must be between 3 and 50 characters.")
	private String lastName;
	
	@NotBlank(message = "The email is required.")
	@Email(message = "Please enter a valid email.")
	@Size(min = 3, max = 50, message = "The length of email must be between 3 and 50 characters.")
	private String email;
	
	@NotNull(message = "The phone number is required.")
	@Positive(message = "The phone number shouldn't be -ve value.")
	@ValidPhoneNumber
	private long phoneNumber;
	
	@NotBlank(message = "The Do date of join is required.")
	@ValidDate
	private String doj;
	
	@NotNull(message = "The salary is required.")
	@Positive(message = "The salary shouldn't be -ve value.")
	@ValidSalary
	private double salary;
}
