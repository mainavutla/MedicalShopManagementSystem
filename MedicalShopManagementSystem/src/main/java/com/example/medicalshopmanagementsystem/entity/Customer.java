package com.example.medicalshopmanagementsystem.entity;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	@Entity
	@Table(name="customer")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public class Customer {
		
		@Id
		@GeneratedValue (generator = "seq" ,strategy = GenerationType.AUTO)
		@SequenceGenerator(name="seq",initialValue = 1000)
		private Long customerId;
		
		@NotNull(message = "this is mandatory field")
		@Size(min=1,message = "please fill firstName")
		private String customerName;
		
		@Length(min=10,max=13,message = "phoneNo cannot be less than 10 characters")
		private String customerPhoneNo;
		
		@Length(min=3,message = "Address cannot be lessthan 3 characters")
		private String customerAddress;
		
		
		
		//@JsonIgnore
		@ManyToOne(cascade = CascadeType.MERGE,fetch=FetchType.LAZY)
		@JoinColumn(name="id")
		private Employee employee;
		
		@JsonIgnore
		@OneToMany(cascade = CascadeType.MERGE, mappedBy = "customer")
		private List<Medicine> Medicines ;

		public Customer() {
			super();
		}

		public Customer(Long customerId,
				@NotNull(message = "this is mandatory field") @Size(min = 1, message = "please fill firstName") String customerName,
				@Length(min = 10, max = 13, message = "phoneNo cannot be less than 10 characters") String customerPhoneNo,
				@Length(min = 3, message = "Address cannot be lessthan 3 characters") String customerAddress,
				Employee employee, List<Medicine> medicines) {
			super();
			this.customerId = customerId;
			this.customerName = customerName;
			this.customerPhoneNo = customerPhoneNo;
			this.customerAddress = customerAddress;
			this.employee = employee;
			Medicines = medicines;
		}

		public Long getCustomerId() {
			return customerId;
		}

		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public String getCustomerPhoneNo() {
			return customerPhoneNo;
		}

		public void setCustomerPhoneNo(String customerPhoneNo) {
			this.customerPhoneNo = customerPhoneNo;
		}

		public String getCustomerAddress() {
			return customerAddress;
		}

		public void setCustomerAddress(String customerAddress) {
			this.customerAddress = customerAddress;
		}

		public Employee getEmployee() {
			return employee;
		}

		public void setEmployee(Employee employee) {
			this.employee = employee;
		}

	/*	public List<Medicine> getMedicines() {
			return Medicines;
		}

		public void setMedicines(List<Medicine> medicines) {
			Medicines = medicines;
		}*/

		@Override
		public String toString() {
			return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerPhoneNo="
					+ customerPhoneNo + ", customerAddress=" + customerAddress + ", employee=" + employee
					+ ", Medicines=" + Medicines + "]";
		}

	
		
	}
		

		