package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

	@Autowired
	private OrdersRepo ordersRepo;
	
	public List<OrderDetails> getOrders() {
		
		return (List<OrderDetails>) ordersRepo.findAll();
	}

	public List<DistinctOrderDetails> getDistinctOrders() {
		List<DistinctOrderDetails> List = ordersRepo.distinctOrders();
		for(DistinctOrderDetails d : List) {
			d.setQty(ordersRepo.getSumByName(d.getCouponCode(), d.getCouponType()));
		}
		return List;
	}

	public List<DistinctOrderDetails> getDistinctOrdersByGroup() {
		return ordersRepo.getDistinctOrdersByGroup();
	}

}
