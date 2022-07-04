package com.example.medicalshopmanagementsystem.service;

import java.util.List;

import com.example.medicalshopmanagementsystem.entity.Employee;



public interface EmployeeService {
	
    public Employee saveOrUpdate(Employee employees) ;
	 
    public List<Employee> findAllEmployee();
   
	public Employee updateEmployeeById(Long theId,Employee employee);
	
	public String deleteEmployee(Long theId);

	public List<Employee> findAllEmployeeByIdInAsc();
	
	public List<Employee> findAllEmployeeByIdInDesc();
	
	public Employee findEmployeeById(Long theId);
	
	public String findEmployeeByUsernameAndPassword(String username, String password);
	
	
	
} 