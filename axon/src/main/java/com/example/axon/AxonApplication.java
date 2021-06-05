package com.example.axon;

import org.axonframework.springboot.autoconfig.JdbcAutoConfiguration;
import org.axonframework.springboot.autoconfig.JpaAutoConfiguration;
import org.axonframework.springboot.autoconfig.JpaEventStoreAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={ErrorMvcAutoConfiguration.class, JpaEventStoreAutoConfiguration.class, JdbcAutoConfiguration.class, JpaAutoConfiguration.class, DataSourceAutoConfiguration.class
		})
public class AxonApplication {

	public static void main(String[] args) {
		SpringApplication.run(AxonApplication.class, args);
	}
}
