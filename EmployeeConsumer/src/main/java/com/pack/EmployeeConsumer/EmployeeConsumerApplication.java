package com.pack.EmployeeConsumer;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

@SpringBootApplication
public class EmployeeConsumerApplication {

	public static void main(String[] args) throws RestClientException, IOException {
ApplicationContext ctx = SpringApplication.run(EmployeeConsumerApplication.class, args);
        
        CustomerControllerClient customerControllerClient=ctx.getBean(CustomerControllerClient.class);
        System.out.println(customerControllerClient);
        customerControllerClient.getEmployee();
    }
    @Bean
    public  CustomerControllerClient  consumerControllerClient()
    {
        return  new CustomerControllerClient();
    }
}


