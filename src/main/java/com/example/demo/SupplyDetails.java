package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@NamedQuery(name = "OrderDetails.getSumByName", query = "SELECT sum(qty) FROM OrderDetails p where couponCode=:couponCode and couponType=:couponType")
public class SupplyDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sId;
	private String couponCode;
	private String couponType;
	private Long qty;
	private String printerName;
	private long totalCount;
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
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
	public String getPrinterName() {
		return printerName;
	}
	public void setPrinterName(String printerName) {
		this.printerName = printerName;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	
	

}
