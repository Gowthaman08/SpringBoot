package com.example.service;


import com.example.entity.Employee;

public interface EmployeeService {

//	public void createEmployee(Employee employee);
	public String createEmployeeSendMail(Employee employee,String toEmail, String subject, String message);
}
