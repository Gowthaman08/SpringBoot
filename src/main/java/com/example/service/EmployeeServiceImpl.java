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
	public String createEmployeeSendMail(Employee employee,String toEmail, String subject, String message)  {
		try {
			System.out.println(toEmail);
			if(toEmail.substring((toEmail.length()-4), (toEmail.length())).equals(".com"))
			{
				if(!(employeeRepository.existsByEmail(toEmail)))
				{
					var mailMessage = new SimpleMailMessage();

					mailMessage.setTo(toEmail);
					mailMessage.setSubject(subject);
					mailMessage.setText(message);

					javaMailSender.send(mailMessage);
					employeeRepository.save(employee);
					msg="Mail sented";
				}
				else
				{
					throw new EmailExist("Email already exists");
				}
			}
			else
			{
				throw new UserDefinedException("com is missing");
			}
		}
		catch(UserDefinedException | EmailExist e)
		{
			msg=e.toString();
		} 
		return msg;
    }
	
	

}

