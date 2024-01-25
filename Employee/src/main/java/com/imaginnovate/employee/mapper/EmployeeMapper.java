package com.imaginnovate.employee.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.imaginnovate.employee.dto.EmployeeDto;
import com.imaginnovate.employee.entity.Employee;
import com.imaginnovate.employee.util.EmployeeConstant;
/*

 * Employee mapper
 * Created on 25-01-2024
 * By Ramakrishna P
 */
public class EmployeeMapper {

	public static Employee toEmployee(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		
		employee.setId(employeeDto.getId());
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setEmail(employeeDto.getEmail());
		employee.setPhoneNumber(employeeDto.getPhoneNumber());
		employee.setDoj(LocalDate.parse(employeeDto.getDoj(), EmployeeConstant.DD_MM_YYYY));
		employee.setSalary(employeeDto.getSalary());
		
		return employee;
	}
	
	public static EmployeeDto toEmployeeDto(Employee employee) {
		EmployeeDto employeeDto = new EmployeeDto();
		
		employeeDto.setId(employee.getId());
		employeeDto.setFirstName(employee.getFirstName());
		employeeDto.setLastName(employee.getLastName());
		employeeDto.setEmail(employee.getEmail());
		employeeDto.setPhoneNumber(employee.getPhoneNumber());
		employeeDto.setDoj(EmployeeConstant.DD_MM_YYYY.format(employee.getDoj()));
		employeeDto.setSalary(employee.getSalary());
		
		return employeeDto;
	}
	
	public static List<EmployeeDto> toEmployeeDtoList(List<Employee> employeeList) {
		List<EmployeeDto> employeeDtos = new ArrayList<>();
		for (int i = 0; i < employeeList.size(); i++) {
			employeeDtos.add(toEmployeeDto(employeeList.get(i)));
		}
		return employeeDtos;
	}
}
