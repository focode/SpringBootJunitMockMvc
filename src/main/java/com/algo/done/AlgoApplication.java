package com.algo.done;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Configuration
@ComponentScan
@SpringBootApplication
public class AlgoApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(AlgoApplication.class, args);
		
		
		
	}
	
	
	
	
	
}
