package com.example.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/Supplier")
public class SupplyController {

	@Autowired
	private SupplyService supplyService;
	
	@Autowired
	private OrderService orderService;
		
	
	@PostMapping("/save")
	public SupplyDetails saveSupplierDetails(@RequestBody SupplyDetails supplyDetails) {
		
//		long sumOfOrderQty = orderService.getSumOfOrderQty(supplyDetails.getCouponCode(),supplyDetails.getCouponType());
//		
//		long sumOfSuppliedQty = supplyService.getSumOfSuppliedQty(supplyDetails.getCouponCode(),supplyDetails.getCouponType());
//		
//		Long balance = sumOfOrderQty - sumOfSuppliedQty;
		
		Long balance = supplyService.getSumByNameByNative(supplyDetails.getCouponCode(),supplyDetails.getCouponType());
		
		if(supplyDetails.getQty() <= balance) {
			return supplyService.save(supplyDetails);
		}
		else {
			//error or prompt  getSumByNameByNative
		}
		
		return null;
	}
	
	
	
	@GetMapping("/all")
	public List<SupplyDetails> getAllSupplier(){
		return supplyService.findAll();
	}

}
