package com.example.medicalshopmanagementsystem.service;

import java.util.List;

import com.example.medicalshopmanagementsystem.entity.Customer;




public interface CustomerService {
		
    public Customer saveOrUpdate(Customer customers) ;
	
	public List<Customer> findAllCustomers();
	
	public Customer findCustomerByCustomerId(Long customerId) ;
	
	public String deleteCustomer(Long customerId);

	public List<Customer> findAllByEmployeeId(Long id);
	
	//public List<Customer>findAllByCustomerName(String customerName) ;

	public String findCustomerByCustomerName(String customerName);

	

	

	

	
}
