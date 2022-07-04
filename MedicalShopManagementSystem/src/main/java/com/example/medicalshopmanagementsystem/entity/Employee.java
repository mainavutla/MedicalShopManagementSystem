package com.example.medicalshopmanagementsystem.entity;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	@Entity
	@Table(name="employee")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

	public class Employee {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="id")
		private Long id;
		
		
		@Column(unique = true)
		@NotBlank(message = "username must be required")
		@Size(min = 3, max = 10, message = "Username consists of atleast 3 characters !!!")
		private String username;
		
		@NotNull(message = "this is mandatory field")
		@Column(name="first_name")
		private String firstName;
		
		@Column(name="last_name")
		private String lastName;
		
		@Size(min = 4, max = 10, message = "Password length must be 4 to 10.")
		private String password;
		
		@Length(min=3,message = "email cannot be lessthan 3 characters")
		@Column(name="email")
		private String email;
		
		@OneToMany(cascade = CascadeType.MERGE,fetch=FetchType.LAZY,mappedBy="employee")
		@JsonIgnore
		private List<Customer> Customers ;

		public Employee() {
			super();
		}

		public Employee(Long id,
				@NotBlank(message = "username must be required") @Size(min = 3, max = 10, message = "Username consists of atleast 3 characters !!!") String username,
				@NotNull(message = "this is mandatory field") String firstName, String lastName,
				@Size(min = 4, max = 10, message = "Password length must be 4 to 10.") String password,
				@Length(min = 3, message = "email cannot be lessthan 3 characters") String email,
				List<Customer> customers) {
			super();
			this.id = id;
			this.username = username;
			this.firstName = firstName;
			this.lastName = lastName;
			this.password = password;
			this.email = email;
			Customers = customers;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		/*public List<Customer> getCustomers() {
			return Customers;
		}

		public void setCustomers(List<Customer> customers) {
			Customers = customers;
		}*/

		@Override
		public String toString() {
			return "Employee [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName="
					+ lastName + ", password=" + password + ", email=" + email + ", Customers=" + Customers + "]";
		}

		
		

	}