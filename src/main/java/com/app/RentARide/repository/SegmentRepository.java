package com.app.RentARide.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.RentARide.entity.Segment;

@Repository
public interface SegmentRepository extends JpaRepository<Segment, Integer> {
	
}
