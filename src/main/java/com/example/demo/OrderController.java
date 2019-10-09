package com.example.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class OrderController {

	@Autowired
	private OrderService orderService;
		
	@RequestMapping("orders")
	public List<OrderDetails> getOrders(){
		return orderService.getOrders();
	}
	
	@RequestMapping("distinctOrders")
	public List<DistinctOrderDetails> getDistinctOrders(){
		return orderService.getDistinctOrders();
	}
	
	@RequestMapping("distinctOrdersBygroup")
	public List<DistinctOrderDetails> getDistinctOrdersByGroup(){
		return orderService.getDistinctOrdersByGroup();
	}
	
	

}
