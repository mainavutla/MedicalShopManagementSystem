package com.example.medicalshopmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.medicalshopmanagementsystem.entity.Customer;
import com.example.medicalshopmanagementsystem.entity.Employee;
import com.example.medicalshopmanagementsystem.exception.CustomNotFoundException;
import com.example.medicalshopmanagementsystem.repository.EmployeeRepository;

	@Service
	public class EmployeeServiceImpl implements EmployeeService {
		
		@Autowired
		 private EmployeeRepository employeeRepository;
		
		public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
			super();
			this.employeeRepository = employeeRepository;
		}
			

		@Override
		public Employee saveOrUpdate(Employee employees)  {
			// TODO Auto-generated method stub
			Employee employee= employeeRepository.save(employees);
			if(employee == null) {
				throw new CustomNotFoundException("Something Went Wrong");
			}
			
			return employee;
		}
			

		@Override
		public List<Employee> findAllEmployee() {
			
          List<Employee> allEmployee= employeeRepository.findAll();
			
			return allEmployee;
		}

		@Override
		public Employee updateEmployeeById(Long theId,Employee employee) {
			Employee result = findEmployeeById(theId);
			if(result != null) {
				employeeRepository.save(employee);
			}
			return employee;
		}
		
		
		@Override
		public String deleteEmployee(Long id) {
			// TODO Auto-generated method stub
			
			Employee theEmployee= findEmployeeById(id);
			
			if(theEmployee != null) {
				employeeRepository.delete(theEmployee);
			}
			else {
				throw new CustomNotFoundException("Employee not found!!!");
			}
			return " deleted Employee"+id;
			
		}
		@Override
		public String findEmployeeByUsernameAndPassword(String username, String password) {
			// TODO Auto-generated method stub
			
			Employee getValidEmployee = employeeRepository.findByUsernameAndPassword(username, password);
			
			if (getValidEmployee == null) {
				throw new CustomNotFoundException("Invalid Credential !!");
			} else {
				System.out.println(getValidEmployee.getUsername());
				return "Ok " + getValidEmployee.getUsername() + "is Available";
			}
			
		}
		

		@Override
		public List<Employee> findAllEmployeeByIdInAsc() {
			// TODO Auto-generated method stub
			List<Employee> employee = employeeRepository.findAllByOrderByIdAsc() ;
			return employee;
		}

		@Override
		public List<Employee> findAllEmployeeByIdInDesc() {
			// TODO Auto-generated method stub
			List<Employee> sortedByDescEmployee = employeeRepository.findAllByOrderByIdDesc();
			return sortedByDescEmployee;
			
		}

		@Override
		public Employee findEmployeeById(Long id) {
			// TODO Auto-generated method stub
       Optional<Employee> result = employeeRepository.findById(id);
			
       Employee employee = null;
			if (result.isPresent()) {
			
				employee = result.get();
			}
			return employee;
			
		}


		
			}

			
		

		

		

		

	
			


		

		


