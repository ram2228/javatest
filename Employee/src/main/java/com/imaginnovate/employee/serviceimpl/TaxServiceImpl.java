package com.imaginnovate.employee.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginnovate.employee.dto.EmployeeTaxDto;
import com.imaginnovate.employee.entity.Employee;
import com.imaginnovate.employee.entity.TaxInformation;
import com.imaginnovate.employee.repository.TaxInformationRepository;
import com.imaginnovate.employee.service.TaxService;
import com.imaginnovate.employee.util.EmployeeConstant;
/*

 * Employee Tax calculation
 * Created on 25-01-2024
 * By Ramakrishna P
 */
@Service
public class TaxServiceImpl implements TaxService {
	
	@Autowired
	private TaxInformationRepository taxInformationRepository;

	@Override
	public List<TaxInformation> getTaxInformationList() {
		return taxInformationRepository.findAll();
	}
	
	public EmployeeTaxDto calculateTaxDeduction(Employee employee) {
		LocalDate fyLocalDate = LocalDate.now();
		int fyYear = fyLocalDate.getYear();
		
		LocalDate doj = employee.getDoj();
		int dojYear = doj.getYear();
		int dojMonth = doj.getMonthValue();
		int dojDay = doj.getDayOfMonth();
		int dojTotalDaysInMonth = doj.lengthOfMonth();
		
		int diffYear = fyYear - dojYear;
		int diffMonths = 0;
		int diffDays = 0;
		
		// calculating the months and days if employee joins in same FY
		if (diffYear == 0 || diffYear >= 1) {
			if (dojMonth < 4) {
				diffMonths = 12;
			} else {
				diffMonths = (12 - dojMonth) + 3;
				if (dojDay == 1) {
					diffMonths++;
				} else {
					diffDays = dojTotalDaysInMonth - dojDay;
				}
			}
		}  else if (diffYear == -1 && dojMonth < 4) {
			diffMonths = 4 - dojMonth;
			if (dojDay == 1) {
				diffMonths++;
			} else {
				diffDays = dojTotalDaysInMonth - dojDay;
			}
		}
		
		List<TaxInformation> taxList = getTaxInformationList();
		final double totalSalary = 
				(Math.round(employee.getSalary()/30) * diffDays) + (employee.getSalary() * diffMonths);
		
		// commenting old code
		/*taxList = taxList.stream()
				.filter(t -> totalSalary >= t.getFromAmount())
				.collect(Collectors.toList());
		
		double taxAmount = 0;
		System.out.println("total salary "+totalSalary);
		//Calculate Tax slab wise
		if (totalSalary > 0) {
			for (int i = 0; i < taxList.size(); i++) {
				TaxInformation taxSlab = taxList.get(i);
				if (totalSalary > taxSlab.getToAmount()) {
					taxAmount = taxAmount + 
							Math.round(((taxSlab.getToAmount() - taxSlab.getFromAmount()) * taxSlab.getTaxPercentage()) / 100);
					System.out.println("TAX slab = "+taxSlab.getToAmount()+" - "+taxSlab.getFromAmount()+" & Amount="+taxAmount);
				} else {
					taxAmount = taxAmount + 
							Math.round(((totalSalary - taxSlab.getFromAmount()) * taxSlab.getTaxPercentage()) / 100);
					System.out.println("ELSE Tax = "+taxSlab.getToAmount()+" - "+taxSlab.getFromAmount()+" & Amount="+taxAmount);
				}
			}
		}*/
						
		double taxAmount = 0;
		System.out.println("total salary "+totalSalary);
		//Calculate Tax slab wise
		if (totalSalary > 0) {
		    taxAmount = taxList.stream()
		            .filter(taxSlab -> totalSalary > taxSlab.getFromAmount())
		            .mapToDouble(taxSlab -> {
		                double taxableAmount = Math.min(taxSlab.getToAmount(), totalSalary) - taxSlab.getFromAmount();
		                return Math.round((taxableAmount * taxSlab.getTaxPercentage()) / 100);
		            })
		            .sum();
		 
		}
		
		
		EmployeeTaxDto employeeTaxDto = new EmployeeTaxDto();
		
		// Cess Tax calculation
		if (totalSalary > EmployeeConstant.CESS_TAX_AMOUNT) {
			
			
			double cessAmount = 
					Math.round(((totalSalary - EmployeeConstant.CESS_TAX_AMOUNT) * EmployeeConstant.CESS_TAX_PERCENTAGE) / 100);;
			System.out.println("CESS Amount: "+cessAmount);
			taxAmount = taxAmount + cessAmount;
			employeeTaxDto.setCessAmount(EmployeeConstant.ZERO_DECIMAL.format(cessAmount));
		}
		
		double inHandSalary = totalSalary - taxAmount;
		
		
		employeeTaxDto.setEmployeeId(employee.getId());
		employeeTaxDto.setFirstName(employee.getFirstName());
		employeeTaxDto.setLastName(employee.getLastName());
		employeeTaxDto.setTotalSalary(EmployeeConstant.ZERO_DECIMAL.format(totalSalary));
		employeeTaxDto.setTaxDeduction(EmployeeConstant.ZERO_DECIMAL.format(taxAmount));
		employeeTaxDto.setInHandSalary(EmployeeConstant.ZERO_DECIMAL.format(inHandSalary));
		
		return employeeTaxDto; 
				
	}

}
