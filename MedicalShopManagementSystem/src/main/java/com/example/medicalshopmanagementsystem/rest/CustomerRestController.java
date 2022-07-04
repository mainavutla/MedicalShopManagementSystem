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

import com.example.medicalshopmanagementsystem.entity.Customer;
import com.example.medicalshopmanagementsystem.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {
	@Autowired
	private CustomerService customerService;
		
		@PostMapping("/")
		public  Customer CustomersaveCustomers(@Valid @RequestBody Customer customer)  {
			Customer theCustomer = customerService.saveOrUpdate(customer);
			
			return theCustomer;
		}
		
		@GetMapping("/")
		public List<Customer> getAllCustomers()  {
			List<Customer> allCustomers = customerService.findAllCustomers();
			return allCustomers ;
		}
		

		@GetMapping("/{customerId}")
		public Customer getCustomerById(@PathVariable Long customerId)   {
			Customer customer = customerService.findCustomerByCustomerId(customerId);
			return customer;
		}
		
		
		
		
		@PutMapping("/")
		public Customer upadteCustomer(@RequestBody Customer customer)    {
			
			Customer result = customerService.saveOrUpdate(customer);
			
			System.err.println("Updated");
			return result;
		}
	
		@DeleteMapping("/{customerId}")
		public String deleteCustomer(@PathVariable Long customerId)  {
			Customer result = customerService.findCustomerByCustomerId(customerId);
			
			if(result.getCustomerId() == customerId) 
				customerService.deleteCustomer(customerId);
				
				return "customer Deleted";
			
		}
		
		
		@GetMapping("/name/{customerName}")
		private String getCustomerByName(@PathVariable String customerName)  {
		
		String customer = customerService.findCustomerByCustomerName(customerName);
		
		return customer;
		}
		
		//Get the customer list according to Employee ID
		@GetMapping("/find/{id}")
		public List<Customer> findAllCustomerByEmployeeId(@PathVariable Long id) {
			List<Customer> customers = customerService.findAllByEmployeeId(id);
			return customers;
		}
		
}

