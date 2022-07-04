package com.example.medicalshopmanagementsystem.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.medicalshopmanagementsystem.entity.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>  {
	
	
//	This method used for employee login using user name and password
	public  Employee findByUsernameAndPassword(String username,String password);
	
//	This method is used for find and save unique user name
	public Employee findByUsername(String username);
	
//	Method for get list of employees in ascending order by employee_id 
	public List<Employee> findAllByOrderByIdAsc();
	
//	Method for get list of employees in descending order by employee_id 
	public List<Employee> findAllByOrderByIdDesc();

	

	

	public Employee findByEmail(String email);
	
	 
	

	
	

}
