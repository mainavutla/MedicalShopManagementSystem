package com.example.medicalshopmanagementsystem.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;






	@Entity
	@Table(name="medicine")
	//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

	public class Medicine implements Serializable {
		
		@Id
		@GeneratedValue (generator = "seq" ,strategy = GenerationType.AUTO)
		@SequenceGenerator(name="seq",initialValue =2000)
		private Long medicineId;
		
		@NotNull(message = "this is mandatory field")
		private String medicineName;
		
		private double medicinePrice;
		
		private String medicineCategory;
		
		private String medicineCompany;
		
		private  int medicineQuantity;
		
		private String manufactureDate;
		
		private String expiraryDate;
		
		//@JsonIgnore
		@ManyToOne(cascade = CascadeType.MERGE,fetch=FetchType.LAZY)
		@JoinColumn(name="customerId")
		private Customer customer;

		public Medicine() {
			super();
		}
		
		

		public Medicine(Long medicineId, @NotNull(message = "this is mandatory field") String medicineName,
				double medicinePrice, String medicineCategory, String medicineCompany, int medicineQuantity,
				String manufactureDate, String expiraryDate, Customer customer) {
			super();
			this.medicineId = medicineId;
			this.medicineName = medicineName;
			this.medicinePrice = medicinePrice;
			this.medicineCategory = medicineCategory;
			this.medicineCompany = medicineCompany;
			this.medicineQuantity = medicineQuantity;
			this.manufactureDate = manufactureDate;
			this.expiraryDate = expiraryDate;
			this.customer = customer;
		}



		public Long getmedicineId() {
			return medicineId;
		}

		public void setMedicineId(Long medicineId) {
			this.medicineId = medicineId;
		}

		public String getMedicineName() {
			return medicineName;
		}

		public void setMedicineName(String medicineName) {
			this.medicineName = medicineName;
		}

		public double getMedicinePrice() {
			return medicinePrice;
		}

		public void setMedicinePrice(double medicinePrice) {
			this.medicinePrice = medicinePrice;
		}

		public String getMedicineCategory() {
			return medicineCategory;
		}

		public void setMedicineCategory(String medicineCategory) {
			this.medicineCategory = medicineCategory;
		}

		public String getMedicineCompany() {
			return medicineCompany;
		}

		public void setMedicineCompany(String medicineCompany) {
			this.medicineCompany = medicineCompany;
		}

		public int getMedicineQuantity() {
			return medicineQuantity;
		}

		public void setMedicineQuantity(int medicineQuantity) {
			this.medicineQuantity = medicineQuantity;
		}

		public String getManufactureDate() {
			return manufactureDate;
		}

		public void setManufactureDate(String manufactureDate) {
			this.manufactureDate = manufactureDate;
		}

		public String getExpiraryDate() {
			return expiraryDate;
		}

		public void setExpiraryDate(String expiraryDate) {
			this.expiraryDate = expiraryDate;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		@Override
		public String toString() {
			return "Medicine [medicineId=" + medicineId + ", medicineName=" + medicineName + ", medicinePrice=" + medicinePrice
					+ ", medicineCategory=" + medicineCategory + ", medicineCompany=" + medicineCompany
					+ ", medicineQuantity=" + medicineQuantity + ", manufactureDate=" + manufactureDate
					+ ", expiraryDate=" + expiraryDate + ", customer=" + customer + "]";
		}

		
}
