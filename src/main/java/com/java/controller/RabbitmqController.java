package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.model.Employee;
import com.java.services.RabbitmqServices;

@RestController
@RequestMapping(value = "/javainuse-rabbitmq/")
public class RabbitmqController {

	@Autowired
	RabbitmqServices rabbitMQSender;

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("empName") String empName,@RequestParam("empId") String empId) {
	
	Employee emp=new Employee();
	emp.setEmpId(empId);
	emp.setEmpName(empName);
		rabbitMQSender.send(emp);
		System.out.println("get emp details");
		return "Message sent to the RabbitMQ JavaInUse Successfully";
	}
}
