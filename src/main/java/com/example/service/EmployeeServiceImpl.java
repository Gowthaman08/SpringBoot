package com.example.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	String toEmail,msg="Mail sented";

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	JavaMailSender javaMailSender;

	
	@Override
	public void createEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public String sendMail(String toEmail, String subject, String message)  {
		try {
			this.toEmail=toEmail;
			var mailMessage = new SimpleMailMessage();

	        mailMessage.setTo(toEmail);
	        mailMessage.setSubject(subject);
	        mailMessage.setText(message);

	        javaMailSender.send(mailMessage);
		}
		catch(NullPointerException e)
		{
			msg=e.toString();
		}
		return msg;
	 	
    }
	
	

}
