package com.example.Spring.JPA3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.entity.Address;
import com.example.entity.Customer;
import com.example.service.CustomerService;
import java.util.List;

@SpringBootApplication
@ComponentScan("com.example")
public class SpringJpa3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpa3Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CustomerService service) {
	    return (args) -> {
	        // Save address
	        Address address1 = service.saveAddress(new Address("MG Road", "Bangalore"));
	        Address address2 = service.saveAddress(new Address("FC Road", "Pune"));

	        // Save customers
	        Customer customer1 = new Customer("Padma");
	        customer1.setAddress(address1);
	        service.saveCustomer(customer1);

	        Customer customer2 = new Customer("Vijayawada");
	        customer2.setAddress(address2);
	        service.saveCustomer(customer2);

	        // Fetch all customers
	        List<Customer> allCustomers = service.getAllCustomers();
	        System.out.println("All Customers: " + allCustomers);

	        // Fetch all customers from a city
	        String city = "Pune";
	        List<Customer> customersFromCity = service.getAllCustomersFromCity(city);
	        System.out.println("Customers from " + city + ": " + customersFromCity);
	    };
	}
}


