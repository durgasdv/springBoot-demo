package com.example.demo;

public class DistinctOrderDetails {
	private String couponCode;
	private String couponType;
	private Long qty;
	
	public DistinctOrderDetails(String couponCode, String couponType, Long qty) {
		this.couponCode = couponCode;
		this.couponType = couponType;
		this.qty = (qty!=null?qty:0);
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

}
