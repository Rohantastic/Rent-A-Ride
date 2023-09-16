package com.app.RentARide.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.RentARide.entity.Vehicle;
import com.app.RentARide.repository.VehicleRepository;


@Service
public class VehicleService {
	@Autowired
	VehicleRepository vehicleRepository;
	
	public List<Vehicle> getAllProduct(){
		return vehicleRepository.findAll();
	}
	
	public void addProduct(Vehicle product) {
		vehicleRepository.save(product);
	}
	
	public void removeProductById(long id ) {
		vehicleRepository.deleteById(id);
	}
	
	public Optional<Vehicle> getProductById(long id){
		return vehicleRepository.findById(id);
	}
	
	public List<Vehicle> getAllProductsByCategoryById(int id){
		return vehicleRepository.findAllByCategory_Id(id);
	}
}
