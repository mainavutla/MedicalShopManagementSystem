package com.example.medicalshopmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.medicalshopmanagementsystem.entity.Customer;
import com.example.medicalshopmanagementsystem.entity.Employee;
import com.example.medicalshopmanagementsystem.exception.CustomNotFoundException;
import com.example.medicalshopmanagementsystem.repository.CustomerRepository;




	@Service
	public class CustomerServiceImpl implements CustomerService {
		
		@Autowired
		private CustomerRepository customerRepository;
		
		
		

		public CustomerServiceImpl(CustomerRepository customerRepository) {
			super();
			this.customerRepository = customerRepository;
		}

		@Override
		public Customer saveOrUpdate(Customer customers)  {
			// TODO Auto-generated method stub
			Customer customer= customerRepository.save(customers);
			if(customer == null) {
				throw new CustomNotFoundException("Something Went Wrong");
			}
			
			return customer;
		}

		@Override
		public List<Customer> findAllCustomers()  {
			// TODO Auto-generated method stub
			
			
			  List<Customer> customerList = customerRepository.findAll();
			  if(customerList.size() == 0)
				  
				  throw new CustomNotFoundException("Currently list is empty !");
				
			return customerList;
		}

		

		@Override
		public String deleteCustomer(Long customerId) {
			// TODO Auto-generated method stub
			
			Customer theCustomer = findCustomerByCustomerId(customerId);
			
			if(theCustomer!= null) 
				customerRepository.delete(theCustomer);
				
			
			else 
				throw new CustomNotFoundException("Customer not found!!!");
				
			return " deleted Customer";
			
			
			
		}

		

		@Override
		public List<Customer> findAllByEmployeeId(Long id)  {
			// TODO Auto-generated method stub
			
			List<Customer> customers =  customerRepository.findAllByEmployeeId(id);
			if(customers.size() >0) {
				return customers;
			}
			else {
				throw new CustomNotFoundException("Customer is not available !!!");
			
		}
		}
	

		@Override
		public Customer findCustomerByCustomerId(Long customerId) {
			// TODO Auto-generated method stub
			 Optional<Customer> result = customerRepository.findById(customerId);
				
		       Customer customer = null;
					if (result.isPresent()) {
					
						customer = result.get();
					}
					return customer;
			
		}

		@Override
		public String findCustomerByCustomerName(String customerName) {
			// TODO Auto-generated method stub
         Customer getValidCustomer = customerRepository.findCustomerByCustomerName(customerName);
			
			if (getValidCustomer == null) {
				throw new CustomNotFoundException("Invalid Credential !!");
			} else {
				System.out.println(getValidCustomer.getCustomerName());
				return "Ok " + getValidCustomer.getCustomerName() + "is Available";
			}
			
		}


	}

