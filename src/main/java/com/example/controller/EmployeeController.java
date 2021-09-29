package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Dao.EmployeeDao;
import com.example.converter.EmployeeConverter;
import com.example.entity.Employee;
import com.example.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeConverter employeeConverter;
	
	@PostMapping(value="/employee/create")
	public ResponseEntity<Object> createEmployee(@RequestBody  EmployeeDao employeeDao)
	{
		Employee employee=employeeConverter.EmployeeDaoToEmployee(employeeDao);
		String msg=employeeService.createEmployeeSendMail(employee,employee.getEmail(), "Password reset link", "You can reset your password https://courseweb.sliit.lk/");
		return new ResponseEntity<Object>(msg,HttpStatus.OK);
	} 

}

