package com.imaginnovate.employee.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginnovate.employee.dto.EmployeeDto;
import com.imaginnovate.employee.dto.EmployeeTaxDto;
import com.imaginnovate.employee.entity.Employee;
import com.imaginnovate.employee.exception.EmployeeNotFoundException;
import com.imaginnovate.employee.exception.UniqueEmailException;
import com.imaginnovate.employee.exception.UniquePhoneNumberException;
import com.imaginnovate.employee.mapper.EmployeeMapper;
import com.imaginnovate.employee.repository.EmployeeRepository;
import com.imaginnovate.employee.service.EmployeeService;
import com.imaginnovate.employee.service.TaxService;
import com.imaginnovate.employee.util.EmployeeConstant;
/*

 * Employee service implementation
 * Created on 25-01-2024
 * By Ramakrishna P
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private TaxService taxService;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee = EmployeeMapper.toEmployee(employeeDto);
		
		if (isEmailExists(employeeDto.getEmail())) {
			throw new UniqueEmailException(EmployeeConstant.UNIQUE_EMAIL);
		}
		
		if (isPhoneNumberExists(employeeDto.getPhoneNumber())) {
			throw new UniquePhoneNumberException(EmployeeConstant.UNIQUE_PHONE_NUMBER);
		}
		
		employee = employeeRepository.save(employee);
		return EmployeeMapper.toEmployeeDto(employee);
	}
	
	@Override
	public EmployeeDto getEmployeeById(int empId) {
		Optional<Employee> empOptional = employeeRepository.findById(empId);
		if (empOptional.isPresent()) {
			return EmployeeMapper.toEmployeeDto(empOptional.get());
		} else {
			throw new EmployeeNotFoundException(EmployeeConstant.Employee_NOT_FOUND);
		}
		
	}

	@Override
	public List<EmployeeDto> getEmployeeList() {
		List<Employee> employeeList = employeeRepository.findAll();
		return EmployeeMapper.toEmployeeDtoList(employeeList);
	}

	@Override
	public EmployeeTaxDto getEmployeeTax(int empId) {
		Optional<Employee> empOptional = employeeRepository.findById(empId);
		if (empOptional.isPresent()) {
			return taxService.calculateTaxDeduction(empOptional.get());
		} else {
			throw new EmployeeNotFoundException(EmployeeConstant.Employee_NOT_FOUND);
		}
	}

	@Override
	public boolean isEmailExists(String email) {
		return employeeRepository.existsByEmail(email);
	}

	@Override
	public boolean isPhoneNumberExists(long phoneNumber) {
		return employeeRepository.existsByPhoneNumber(phoneNumber);
	}
	
}
