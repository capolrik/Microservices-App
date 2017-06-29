package com.backend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WithJsonApplication {

	
	 public static void main(String[] args)
	    {
		 SpringApplication app = new SpringApplication(WithJsonApplication.class);
		 app.setWebEnvironment(false);
		 ConfigurableApplicationContext ctx = app.run(args);
	}

	    @Bean
	    TaskProducer taskproducer(){
	    	return new TaskProducer();
	    }

}
