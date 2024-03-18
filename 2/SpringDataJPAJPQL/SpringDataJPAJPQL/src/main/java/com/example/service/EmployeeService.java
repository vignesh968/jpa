package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.EmployeeRepository;
import com.example.entity.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository repository;
	 
	public int saveEmployee(Employee emp){
		 Employee savedEmployee = repository.save(emp);
	     return savedEmployee.getEmpId();
	}
	public List<Employee> findEmployeesByNameLike (String pattern){
		return repository.findByNameLike("%" + pattern + "%");
	}
	 
	public List<Employee> findEmployeesBySalaryGreaterThanEqual(double salary){
		return repository.FindBySalaryGreaterthanEqual(salary);
	}
	 
	public Integer updateBaseLocation(int empId, String newBaseLocation){
		return repository.updateDesignation(empId, newBaseLocation);
	}

	 
	public List<Employee> findByLocationOrderByName(String baselocation) {
		return repository.findByBaseLocationOrderByEmpNameDesc(baselocation);
 //add code to modify this return value
	 
	} 
	public List<Employee> findByBaseLocationAndDesignation (String baselocation, String designation){
		return repository.findByBaseLocationAndDesignation(baselocation, designation); //add code to modify this return value
	}
	public List<Employee> findEmployeesBySalaryBetween(double lowerLimit, double upperLimit){ 
		return repository.findBySalaryBetween(lowerLimit, upperLimit); //add code to modify this return value
	}
}
