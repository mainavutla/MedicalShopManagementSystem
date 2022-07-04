package com.example.medicalshopmanagementsystem.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.medicalshopmanagementsystem.entity.Medicine;


@Repository
public interface MedicineRepository  extends JpaRepository<Medicine, Long>{
	

	
//	This method is used for  get the all Medicine according to MedicinePrice in descending order.
	public List<Medicine> findAllByOrderByMedicinePriceDesc();

	public List<Medicine> findByMedicineId(Long medicineId);
	
	public List<Medicine> findAllByOrderByMedicinePriceAsc();

	

	public Medicine findMedicineByMedicineName(String medicineName);
	
	
	
	

}
