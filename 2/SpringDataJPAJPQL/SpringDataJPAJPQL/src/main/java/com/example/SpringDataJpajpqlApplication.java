package com.example;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.entity.Employee;
import com.example.service.EmployeeService;
@SpringBootApplication
@ComponentScan("com.example")
public class SpringDataJpajpqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpajpqlApplication.class, args);
	}
	
	@Bean	 
	public CommandLineRunner demo(EmployeeService service) {
	 
	return (args) -> {
	service.saveEmployee(new Employee("Suman", 120000, "Pune", "Consultant"));	 
	service.saveEmployee(new Employee("Ajay", 25000, "Bangalore", "Trainee"));	 
	service.saveEmployee(new Employee("Sree", 95000, "Chennai", "Manager"));	 
	service.saveEmployee(new Employee("Anjali", 80000, "Chennai", "Associate Consultant")); 
	service.saveEmployee(new Employee("Smith", 90000, "Bangalore", "Manager"));
	
	System.out.println(service.findEmployeesByNameLike("S%"));
	
	System.out.println(service.findEmployeesBySalaryGreaterThanEqual(50000));
	 
	// update base location to 'Mumbai'of employee having id 23 
	System.out.println(service.updateBaseLocation(23, "Mumbai")+ "record/s updated");
	 
	// find employees by base location, display in descending order of their name 
	System.out.println(service.findByLocationOrderByName("Bangalore"));
	 
	// find employees by given base location and designation
	 
	System.out.println(service.findByBaseLocationAndDesignation("Chennai", "Manager"));
	 
	// find employees having salary between given range
	 
	System.out.println(service.findEmployeesBySalaryBetween(25000, 90000));
	};
	}
}
