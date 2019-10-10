package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SupplyService {

	@Autowired
	private SupplyRepo supplyRepo;
	
	public Long getSumOfSuppliedQty(SupplyDetails supplyDetails) {
		return supplyRepo.getSumByName(supplyDetails.getCouponCode(), supplyDetails.getCouponType());
	}
	
	public Long getSumOfSuppliedQty(String couponCode,String couponType ) {
		return supplyRepo.getSumByName( couponCode, couponType );
	}

	public SupplyDetails save(SupplyDetails supplyDetails) {
		return supplyRepo.save(supplyDetails);
	}
	
	public Long getSumByNameByNative(String couponCode,String couponType ) {
		return supplyRepo.getSumByNameByNative( couponCode, couponType );
	}
	

	public List<SupplyDetails> findAll() {
		return supplyRepo.findAll();
	}

}
