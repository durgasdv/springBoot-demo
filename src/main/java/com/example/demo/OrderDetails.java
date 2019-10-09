package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "OrderDetails.getSumByName", query = "SELECT sum(qty) FROM OrderDetails p where couponCode=:couponCode and couponType=:couponType")
public class OrderDetails {
	@Id
	private int oId;
	private String couponCode;
	private String couponType;
	private Long qty;
	private Integer qtyCount;
	private long totalCount;
	
	public OrderDetails(String couponCode, String couponType, Long qty) {
		this.couponCode = couponCode;
		this.couponType = couponType;
		this.qty = (qty!=null?qty:0);
	}
	public int getoId() {
		return oId;
	}
	public void setoId(int oId) {
		this.oId = oId;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public String getCouponType() {
		return couponType;
	}
	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}
	public Long getQty() {
		return qty;
	}
	public void setQty(Long qty) {
		this.qty = qty;
	}
	public Integer getQtyCount() {
		return qtyCount;
	}
	public void setQtyCount(Integer qtyCount) {
		this.qtyCount = qtyCount;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	
	
	

}
