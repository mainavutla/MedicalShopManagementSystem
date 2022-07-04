package com.example.medicalshopmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.medicalshopmanagementsystem.entity.Customer;
import com.example.medicalshopmanagementsystem.entity.Medicine;
import com.example.medicalshopmanagementsystem.exception.CustomNotFoundException;
import com.example.medicalshopmanagementsystem.repository.MedicineRepository;


@Service
public class MedicineServiceImpl implements MedicineService {
	@Autowired
	private MedicineRepository medicineRepository;
	
	
	

	public MedicineServiceImpl(MedicineRepository medicineRepository) {
		super();
		this.medicineRepository = medicineRepository;
	}

	@Override
	public Medicine saveOrUpdate(Medicine medicines) {
		// TODO Auto-generated method stub
		
		Medicine medicine= medicineRepository.save(medicines);
		if(medicine == null) {
			throw new CustomNotFoundException("Something Went Wrong");
		}
		
		return medicine;
		
	}

	@Override
	public List<Medicine> findAllMedicines()  {
		// TODO Auto-generated method stub
		List<Medicine> medicineList = medicineRepository.findAll();
		  if(medicineList.size() == 0)
			  
			  throw new CustomNotFoundException("Currently list is empty !");
			
		return medicineList;
		
	}

	
	@Override
	public Medicine findMedicineByMedicineId(Long medicineId) {
		// TODO Auto-generated method stub
		 Optional<Medicine> result = medicineRepository.findById(medicineId);
			
	      Medicine medicine = null;
				if (result.isPresent()) {
				
					medicine = result.get();
				}
				return medicine;
		
	}


	

	@Override
	public String deleteMedicine(Long medicineId)  {
		// TODO Auto-generated method stub
		
		
		Medicine theMedicine = findMedicineByMedicineId(medicineId);
		
		if(theMedicine != null)
			medicineRepository.delete(theMedicine);
		else 
			throw new CustomNotFoundException("Medicine not found!!!");
		return " deleted medicine"+medicineId;
	}
	
	
	@Override
	public List<Medicine> findAllByOrderByMedicinePriceDesc(){
		// TODO Auto-generated method stub
		List<Medicine> medicine = medicineRepository.findAllByOrderByMedicinePriceDesc() ;
		return medicine;
	}
	
	
	@Override
	public List<Medicine> findAllByOrderByMedicinePriceAsc(){
		// TODO Auto-generated method stub
		List<Medicine> medicine = medicineRepository.findAllByOrderByMedicinePriceAsc() ;
		return medicine;
	}
	
	@Override
	public String findMedicineByMedicineName(String medicineName) {
		// TODO Auto-generated method stub
     Medicine getValidMedicine = medicineRepository.findMedicineByMedicineName(medicineName);
		
		if (getValidMedicine == null) {
			throw new CustomNotFoundException("Invalid Credential !!");
		} else {
			System.out.println(getValidMedicine.getMedicineName());
			return "Ok " + getValidMedicine.getMedicineName() + "is Available";
		}
		
	}
	
	
	

	
	}

/*	@Override
	public List<Medicine> findAllByCustomerId(Long customerId)  {
		// TODO Auto-generated method stub
		
		List<Medicine> medicines =  medicineRepository.findAllByCustomerId(customerId);
		if(medicines.size() >0) {
			return medicines;
		}
		else 
			throw new CustomNotFoundException("Customer is not available !!!");
		
	}*/
	


