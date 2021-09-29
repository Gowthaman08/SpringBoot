package com.example.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	String toEmail,msg;
	int count=0;

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
			if(toEmail.substring((toEmail.length()-4), (toEmail.length())).equals(".com"))
			{
				var mailMessage = new SimpleMailMessage();

		        mailMessage.setTo(toEmail);
		        mailMessage.setSubject(subject);
		        mailMessage.setText(message);

		        javaMailSender.send(mailMessage);
		        msg="Mail sented";
			}
			else
			{
				throw new UserDefinedException("com is missing");
			}
		}
		catch(UserDefinedException e)
		{
			msg=e.toString();
		} 
		return msg;
	 	
    }
	
	

}

