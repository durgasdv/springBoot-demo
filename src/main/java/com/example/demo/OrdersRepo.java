package com.example.demo;

import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepo extends JpaRepository<OrderDetails, Integer> {

	@Query("select distinct NEW com.example.demo.DistinctOrderDetails(couponCode,couponType) from OrderDetails")
	public List<DistinctOrderDetails> distinctOrders();
	
	@Query("SELECT NVL(sum(qty),0) FROM OrderDetails p where couponCode=:couponCode and couponType=:couponType")
	public Long getSumByName(@Param("couponCode") String couponCode,@Param("couponType") String couponType);


	
	@Query("SELECT NEW com.example.demo.DistinctOrderDetails(couponCode,couponType,sum(qty)) FROM OrderDetails p group by couponCode,couponType")
	public List<DistinctOrderDetails> getDistinctOrdersByGroup();
	
}