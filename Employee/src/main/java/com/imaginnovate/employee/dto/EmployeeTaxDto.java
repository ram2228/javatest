package com.imaginnovate.employee.dto;

/*

 * Employee tax dto
 * Created on 25-01-2024
 * By Ramakrishna P
 */
public class EmployeeTaxDto {

	private int employeeId;
	
	private String firstName;
	
	private String lastName;
	
	private String totalSalary;
	
	private String taxDeduction;
	
	private String inHandSalary;
	
	private String cessAmount;
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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

	public String getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(String totalSalary) {
		this.totalSalary = totalSalary;
	}

	public String getTaxDeduction() {
		return taxDeduction;
	}

	public void setTaxDeduction(String taxDeduction) {
		this.taxDeduction = taxDeduction;
	}

	public String getInHandSalary() {
		return inHandSalary;
	}

	public void setInHandSalary(String inHandSalary) {
		this.inHandSalary = inHandSalary;
	}
	
	public String getCessAmount() {
		return cessAmount;
	}

	public void setCessAmount(String cessAmount) {
		this.cessAmount = cessAmount;
	}

	
}
