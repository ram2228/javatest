package com.imaginnovate.employee.service;

import java.util.List;

import com.imaginnovate.employee.dto.EmployeeTaxDto;
import com.imaginnovate.employee.entity.Employee;
import com.imaginnovate.employee.entity.TaxInformation;

public interface TaxService {

	public List<TaxInformation> getTaxInformationList();
	
	public EmployeeTaxDto calculateTaxDeduction(Employee employee);
}
