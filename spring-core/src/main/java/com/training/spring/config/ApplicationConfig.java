package com.training.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.training.spring.Car;
import com.training.spring.Person;

public class ApplicationConfig {

		@Bean
		public Person person()
		{
			Person p1= new Person();
			p1.setLastName("Miller");
			return p1;
		}
		@Bean
		public Car car()
		{
			Car c1= new Car();
			c1.setMake("Mercedes");
			c1.setModel("Maybach");
			c1.setYear(2022);
			return c1;
		}
}
