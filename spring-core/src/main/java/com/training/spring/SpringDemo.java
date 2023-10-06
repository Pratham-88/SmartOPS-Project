package com.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.spring.config.ApplicationConfig;

public class SpringDemo {

	public static void main(String[] args) {
		 //ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationConfig.xml");
		   ApplicationContext javaContext = new AnnotationConfigApplicationContext(ApplicationConfig.class); 
		/*Person p1 = (Person)context.getBean("person");
		 System.out.println(p1.getFirstName()+":"+p1.getAge());
		 Person p2 = (Person)context.getBean("person");
		 p2.setFirstName("Peter");
		 System.out.println(p1.getFirstName()+":"+p1.getAge());
		 System.out.println(p1.getMyCar().getCarDetails());
		 Car c1 = (Car)context.getBean("car");
		 System.out.println(c1.getMake()+":"+c1.getYear());*/
		   Person p2 = javaContext.getBean(Person.class);
		   System.out.println(p2.getLastName());
		  // Car c2= javaContext.getBean(Car.class);
		   System.out.println(p2.getMyCar().getCarDetails());
	}

}
