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
		// TODO Auto-generated method stub
		List<Object[]> distinctList= ordersRepo.distinctOrders();
		List<DistinctOrderDetails> List = new ArrayList<DistinctOrderDetails>();
		for(Object[] d : distinctList) {
			List.add(new DistinctOrderDetails(d[0].toString(),d[1].toString(),ordersRepo.getSumByName(d[0].toString(), d[1].toString())));
		}
		
		return List;
	}


	public List<DistinctOrderDetails> getDistinctOrdersByGroup() {
		List<Object[]> distinctList= ordersRepo.getDistinctOrdersByGroup();
		List<DistinctOrderDetails> List = new ArrayList<DistinctOrderDetails>();
		for(Object[] d : distinctList) {
			List.add(new DistinctOrderDetails(d[0].toString(),d[1].toString(),(Long) d[2]));
		}
		return List;
	}


}
