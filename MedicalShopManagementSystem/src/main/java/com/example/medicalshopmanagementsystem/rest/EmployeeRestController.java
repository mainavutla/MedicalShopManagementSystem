package com.example.medicalshopmanagementsystem.rest;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.medicalshopmanagementsystem.entity.Employee;

import com.example.medicalshopmanagementsystem.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/")
	private Employee saveEmployee(@Valid @RequestBody Employee theEmployee)  {

		Employee employee = employeeService.saveOrUpdate(theEmployee);	
		
		return theEmployee;
	}
	
	
	

	@GetMapping("/")
	private List<Employee> getAllEmployee() {
		List<Employee> employeeList = employeeService.findAllEmployee();
		return employeeList;
	}

	@GetMapping("/{id}")
	private Employee getEmployeeById(@PathVariable Long id)  {
		Employee employee = employeeService.findEmployeeById(id);
		return employee;
	}

	@GetMapping("/byAsc")
	private List<Employee> findAllByOrderByIdAsc() {
		List<Employee> sortedByAscEmployee = employeeService.findAllEmployeeByIdInAsc();
		return sortedByAscEmployee;
	}

	@GetMapping("/byDesc")
	private List<Employee> findAllByOrderByIdDesc() {
		List<Employee> sortedByDescEmployee = employeeService.findAllEmployeeByIdInDesc();
		return sortedByDescEmployee;
	}

	
	
	
	@GetMapping("/login/{username}/{password}")
	private String loginEmployee(@PathVariable String username, @PathVariable String password)  {
	
	String employee = employeeService.findEmployeeByUsernameAndPassword(username, password);
	
	return employee;
	}
	
	

	@PutMapping("/")
	private Employee  updateEmployee( @RequestBody Employee employee) {
		Employee result = employeeService.saveOrUpdate(employee);
		
		System.err.println("Updated");
		return employee;

	}
	
	
	@DeleteMapping("/{id}")
	private String deleteEmployee(@PathVariable Long id)  {

		
		Employee result = employeeService.findEmployeeById(id);
		
		if(result.getId() == id) 
			employeeService.deleteEmployee(id);
			
			return "Employee Deleted";
		
}
}
