package com.example.medicalshopmanagementsystem.service;

import java.util.List;

import com.example.medicalshopmanagementsystem.entity.Medicine;

public interface MedicineService {
	
    public Medicine saveOrUpdate( Medicine medicines) ;
	public List<Medicine> findAllMedicines();
	public List<Medicine> findAllByOrderByMedicinePriceAsc();
	public  String deleteMedicine(Long medicineId);
	public Medicine findMedicineByMedicineId(Long medicineId) ;
	public List<Medicine> findAllByOrderByMedicinePriceDesc();
	
	public String findMedicineByMedicineName(String medicineName);

	

   

}
