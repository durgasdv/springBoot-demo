package com.example.demo;

import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepo extends JpaRepository<OrderDetails, Integer> {

	@Query("select distinct couponCode,couponType from OrderDetails")
	public List<Object[]> distinctOrders();
	
	/** You can uses @NamedQuery or
	 * @Query("SELECT sum(qty) FROM OrderDetails p where couponCode=:couponCode and couponType=:couponType")")
	 * @param couponCode
	 * @param couponType
	 * @return
	 * FIX-ME get entity instead of Object[]
	 */
	public Long getSumByName(@Param("couponCode") String couponCode,@Param("couponType") String couponType);


	@Query("SELECT couponCode,couponType,sum(qty) FROM OrderDetails p group by couponCode,couponType")
	public List<Object[]> getDistinctOrdersByGroup();
}