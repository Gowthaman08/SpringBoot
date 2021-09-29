package com.example.service;


import com.example.entity.Employee;

public interface EmployeeService {

	public void createEmployee(Employee employee);
	public String sendMail(String toEmail, String subject, String message);
}
