package com.imaginnovate.employee.exception;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.imaginnovate.employee.dto.ErrorDto;
import com.imaginnovate.employee.util.EmployeeConstant;

/*

 * Employee exception handler
 * Created on 23-01-2024
 * By Ramakrishna P
 */

@ControllerAdvice
public class RestResponseEntityExceptionHandler{

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDto> handleInvalidInputException(MethodArgumentNotValidException e) {
		
		List<String> errors = e.getFieldErrors()
				.stream()
				.map(er -> er.getDefaultMessage())
				.collect(Collectors.toList());
		
		ErrorDto dto = new ErrorDto();
		dto.setCode(HttpStatus.BAD_REQUEST.value());
		dto.setMessage(errors.toString());
		dto.setTime(EmployeeConstant.DD_MM_YYYY_T_HH_MM_SS.format(LocalDateTime.now()));
		
		return new ResponseEntity<ErrorDto>(dto, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({EmployeeNotFoundException.class, 
		UniqueEmailException.class, 
		UniquePhoneNumberException.class})
	public ResponseEntity<ErrorDto> handleEmployeeNotFoundException(RuntimeException e) {
		
		ErrorDto dto = new ErrorDto();
		dto.setCode(HttpStatus.BAD_REQUEST.value());
		dto.setMessage(e.getMessage());
		dto.setTime(EmployeeConstant.DD_MM_YYYY_T_HH_MM_SS.format(LocalDateTime.now()));
		
		return new ResponseEntity<ErrorDto>(dto, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDto> handleAllException(Exception e) {
		
		ErrorDto dto = new ErrorDto();
		dto.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		dto.setMessage(e.getMessage());
		dto.setTime(EmployeeConstant.DD_MM_YYYY_T_HH_MM_SS.format(LocalDateTime.now()));
		
		return new ResponseEntity<ErrorDto>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
