package com.example.medicalshopmanagementsystem.repository;



import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.example.medicalshopmanagementsystem.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	public List<Customer> findAllByEmployeeId(Long id);

	public List<Customer> findByCustomerId(Long customerId);

	
	public List<Customer> findAllByOrderByCustomerIdAsc();

	
	public Customer findCustomerByCustomerName(String customerName);

	
	
}
