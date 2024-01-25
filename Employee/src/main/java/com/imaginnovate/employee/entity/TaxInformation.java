package com.imaginnovate.employee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;


/*

 * Employee tax information
 * Created on 23-01-2024
 * By Ramakrishna P
 */

@NoArgsConstructor
@Entity
@Table(name = "emp_tax_information")
public class TaxInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTaxPercentage() {
		return taxPercentage;
	}

	public void setTaxPercentage(double taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	public double getFromAmount() {
		return fromAmount;
	}

	public void setFromAmount(double fromAmount) {
		this.fromAmount = fromAmount;
	}

	public double getToAmount() {
		return toAmount;
	}

	public void setToAmount(double toAmount) {
		this.toAmount = toAmount;
	}

	private double taxPercentage;
	
	private double fromAmount;
	
	private double toAmount;
}
