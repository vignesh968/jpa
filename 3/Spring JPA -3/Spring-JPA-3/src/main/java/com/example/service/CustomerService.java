package com.example.service;

import com.example.dao.AddressRepository;
import com.example.dao.CustomerRepository;
import com.example.entity.Address;
import com.example.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
	@Autowired
    private CustomerRepository customerRepository;
	@Autowired
    private AddressRepository addressRepository;
    

//    public CustomerService() {
//		super();
//	}
//
//	@Autowired
//    public CustomerService(CustomerRepository customerRepository, AddressRepository addressRepository) {
//        this.customerRepository = customerRepository;
//        this.addressRepository = addressRepository;
//    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public List<Customer> getAllCustomersFromCity(String city) {
        return customerRepository.findAll().stream()
            .filter(customer -> city.equals(customer.getAddress().getCity()))
            .collect(Collectors.toList());
    }
}
