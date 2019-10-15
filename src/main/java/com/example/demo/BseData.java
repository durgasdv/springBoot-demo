package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BseData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sId;
	private String name;
	private String address;
	private long phoneNo;
	
	public BseData() {
	}
	public BseData(int sId, String name, String address, long phoneNo) {
		this.sId = sId;
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	

}
