package com.imaginnovate.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.imaginnovate.employee.dto.EmployeeDto;
import com.imaginnovate.employee.dto.EmployeeTaxDto;
import com.imaginnovate.employee.service.EmployeeService;

import jakarta.validation.Valid;

/*

 * controller to create services like create, update, get employee , employee tax
 * Created on 25-01-2024
 * By Ramakrishna P
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService employeeService;

	// create employee
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public EmployeeDto createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
		//employeeDto.setId(0);
		return employeeService.saveEmployee(employeeDto);
	}

	// to get employee tax
	@GetMapping("/{empId}")
	public EmployeeTaxDto getEmployeeTax(@PathVariable int empId) {
		return employeeService.getEmployeeTax(empId);
	}
	// update employee
	@PutMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public EmployeeDto updateEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
		return employeeService.saveEmployee(employeeDto);
	}


}
