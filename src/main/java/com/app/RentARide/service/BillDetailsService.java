package com.app.RentARide.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.RentARide.entity.BillingDetails;
import com.app.RentARide.repository.BillDetailsRepository;


@Service
public class BillDetailsService {

	@Autowired
	BillDetailsRepository bill;
	
	public  void addBillDetails(BillingDetails billingDetails) {
		bill.save(billingDetails);
	}
}

