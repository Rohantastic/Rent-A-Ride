package com.app.RentARide.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.RentARide.entity.BillingDetails;



public interface BillDetailsRepository extends JpaRepository<BillingDetails, Integer> {
	

}
