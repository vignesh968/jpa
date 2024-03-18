package com.example.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.Employee;

import jakarta.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query("from Employee where empName Like concat('%',:pattern,'%')")
	List<Employee> findByNameLike(@Param("pattern") String pattern) ;
	
	@Query("from Employee where empSalary >= :salary")
	List<Employee> FindBySalaryGreaterthanEqual(@Param("salary") double salary);
	
	@Modifying
	@Transactional
	@Query("UPDATE Employee e SET e.designation = :newDesignation WHERE e.empId = :empId")
	Integer updateDesignation(@Param("empId") int empId,@Param("newDesignation") String newBaseLocation);
	
	@Query("SELECT e FROM Employee e WHERE e.salary BETWEEN :lowerLimit AND :upperLimit")
	List<Employee> findBySalaryBetween(@Param("lowerLimit") double lowerLimit,@Param("upperLimit") double upperLimit);
	
	List<Employee> findByBaseLocationOrderByEmpNameDesc(@Param("baseLocation") String baseLocation);
	
	List<Employee> findByBaseLocationAndDesignation(@Param("baseLocation") String baseLocation,@Param("designation") String designation);
}
