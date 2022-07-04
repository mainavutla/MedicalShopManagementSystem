package com.example.medicalshopmanagementsystem;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import com.example.medicalshopmanagementsystem.entity.Employee;
import com.example.medicalshopmanagementsystem.repository.EmployeeRepository;





@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class EmployeeTest {

	@Autowired
	EmployeeRepository eRepo;
	@Test
	   @Order(1)
	   public void testCreateEmployee() {
		  Employee emp=new Employee();
		  emp.setId((long) 16);
		  emp.setUsername("radha");
		  emp.setFirstName("Radha");
		  emp.setLastName("krishna");
		  emp.setPassword("radha2");
		  emp.setEmail("radha26@gmail.com");
		  eRepo.save(emp);
		 assertNotNull(eRepo.findById((long)15).get()); 
			
		}
	
	   @Test
	   @Order(2)
	   public void testReadAllEmployee() {
		   List<Employee> list=eRepo.findAll();
		   assertThat(list).size().isGreaterThan(0);
		   
		   
	   }
	   @Test
	   @Order(3)
	   public void testSingleEmployee() {
		   Employee employee=eRepo.findById((long) 3).get();
		   assertEquals("Sandeep",employee.getFirstName());
		   
	   }
	  @Test
	   @Order(4)
	   public void testUpdateEmployee() {
		 Employee e=eRepo.findById((long) 3).get();
		 e.setFirstName("Raj");
		 eRepo.save(e);
		 assertNotEquals("Sandeep",eRepo.findById((long) 3).get().getFirstName());
		   
	   }
	   @Test
	   @Order(5)
	   public void testDeleteEmployee() {
		   eRepo.deleteById((long) 10);
		   assertThat(eRepo.existsById((long) 10)).isFalse();
	   }
	   

}
