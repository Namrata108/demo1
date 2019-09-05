package com.java.services;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.java.model.Employee;

@Service
public class RabbitmqServices {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${javainuse.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${javainuse.rabbitmq.routingkey}")
	private String routingkey;	
	String kafkaTopic = "java_in_use_topic";
	
	public void send(Employee company) {
		amqpTemplate.convertAndSend(exchange, routingkey, company);
		System.out.println("Send msg = " + company);
	    
	}
	@Component
	public class RabbitMQConsumer {

		@RabbitListener(queues = "${javainuse.rabbitmq.queue}")
		public void recievedMessage(Employee employee) {
			System.out.println("Recieved Message From RabbitMQ: " + employee);
		}
}
}