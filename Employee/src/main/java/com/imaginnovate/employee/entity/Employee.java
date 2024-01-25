package com.imaginnovate.employee.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

import lombok.NoArgsConstructor;

import jakarta.persistence.Id;

/*

 * Entity for set and get methods of employee data
 * Created 23-01-2024
 * By Ramakrishna P
 */
@NoArgsConstructor
@Entity
@Table(name = "Employee_info")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private long phoneNumber;
	
	private LocalDate doj;
	
	private double salary;
	
	
}
