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
import com.example.medicalshopmanagementsystem.entity.Medicine;
import com.example.medicalshopmanagementsystem.service.MedicineService;

@RestController
@RequestMapping("/medicines")
public class MedicineRestController {
	@Autowired
	private MedicineService medicineService;
	
	
	@PostMapping("/")
	public  Medicine MedicinesaveMedicines(@Valid @RequestBody Medicine medicine)  {
		Medicine theMedicine = medicineService.saveOrUpdate(medicine);
		
		return theMedicine;
	}
	@GetMapping("/")
	public List<Medicine> getAllMedicines()  {
		List<Medicine> allMedicines = medicineService.findAllMedicines();
		return allMedicines ;
	}
	

	
	@GetMapping("/{medicineId}")
	public Medicine getMedicineById(@PathVariable Long medicineId)  {
		Medicine medicine = medicineService.findMedicineByMedicineId(medicineId);
		return medicine;
	}
	
	
	@PutMapping("/")
	public Medicine upadteMedicines(@RequestBody Medicine  medicine)  {
		
		Medicine result = medicineService.saveOrUpdate(medicine);
		
		System.err.println("Updated");
		return result;
	}

	@DeleteMapping("/{medicineId}")
	public String deleteMedicine(@PathVariable Long medicineId)  {
		
           Medicine result = medicineService.findMedicineByMedicineId(medicineId);
		
		if(result.getmedicineId() == medicineId) 
			medicineService.deleteMedicine(medicineId);
			
			return "Medicine Deleted";
		
	}
	@GetMapping("/byDesc")
	private List<Medicine> findAllByOrderByMedicinePriceDesc() {
		List<Medicine> sortedByDescMedicine = medicineService.findAllByOrderByMedicinePriceDesc();
		return sortedByDescMedicine;
	}
	
	
	@GetMapping("/byAsc")
	private List<Medicine> findAllByOrderByMedicinePriceAsc() {
		List<Medicine> sortedByAscMedicine = medicineService.findAllByOrderByMedicinePriceAsc();
		return sortedByAscMedicine;
	}
	
	@GetMapping("/name/{medicineName}")
	private String getMedicineByName(@PathVariable String medicineName)  {
	
	String medicine = medicineService.findMedicineByMedicineName(medicineName);
	
	return medicine;
	}

	
	
	
	
	
}

