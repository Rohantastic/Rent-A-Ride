package com.app.RentARide.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.RentARide.entity.Segment;
import com.app.RentARide.repository.SegmentRepository;


@Service
public class SegmentService {
	@Autowired
	SegmentRepository categoryRepository;
	
	public List<Segment> getAllCategory(){
		return categoryRepository.findAll();
	}
	
	public  void addCatrgory(Segment category) {
		categoryRepository.save(category);
	}
	public void removeCategoryById(int id) {
		categoryRepository.deleteById(id);
	}
	
	public Optional<Segment> getCategoryById(int id) {
		return categoryRepository.findById(id);
	}

}
