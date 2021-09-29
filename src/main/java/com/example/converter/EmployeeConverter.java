package com.example.converter;

import com.example.Dao.EmployeeDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.entity.Employee;
import com.example.service.EmployeeService;

@Component
public class EmployeeConverter {
	
	public Employee EmployeeDaoToEmployee(EmployeeDao employeeDao)
	{
		Employee employee = new Employee();
		employee.setId(employeeDao.getId());
		employee.setName(employeeDao.getName());
		employee.setEmail(employeeDao.getEmail());
		employee.setAddress(employeeDao.getAddress());
		return employee;
		
	}
	public EmployeeDao EmployeeToEmployeeDao(Employee employee)
	{
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.setId(employee.getId());
		employeeDao.setName(employee.getName());
		employeeDao.setEmail(employee.getEmail());
		employeeDao.setAddress(employee.getAddress());
		return employeeDao;
		
	}
	public List<EmployeeDao> EmployeeListToEmployeeDaoList(List<Employee> employeeList)
	{
		List<EmployeeDao> employeeDaoList=new ArrayList<>();
		for(Employee employee:employeeList)
		{
			EmployeeDao employeeDao=new EmployeeDao();
			employeeDao.setId(employee.getId());
			employeeDao.setName(employee.getName());
			employeeDao.setEmail(employee.getEmail());
			employeeDao.setAddress(employee.getAddress());
			employeeDaoList.add(employeeDao);
		}
		return employeeDaoList;
		
	}
}
