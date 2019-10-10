package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplyRepo extends JpaRepository<SupplyDetails, Integer> {

	@Query("SELECT NVL(sum(qty),0) FROM SupplyDetails p where couponCode=:couponCode and couponType=:couponType")
	public Long getSumByName(@Param("couponCode") String couponCode,@Param("couponType") String couponType);

	@Query(value = "SELECT (SELECT  NVL(SUM(A.QTY),0) FROM ORDER_DETAILS A WHERE  A.COUPON_CODE = :couponCode AND A.COUPON_TYPE = :couponType )  - \r\n" + 
			"(SELECT  NVL(SUM(A.QTY),0) FROM SUPPLY_DETAILS A WHERE  A.COUPON_CODE = :couponCode AND A.COUPON_TYPE = :couponType ) SUPPLY_QTY FROM \r\n" + 
			"DUAL", nativeQuery = true)
	public Long getSumByNameByNative(@Param("couponCode") String couponCode,@Param("couponType") String couponType);
	
}