package com.naveen.springcloud.dto;

import java.math.BigDecimal;

public class Coupon {
	private Long id; // for storing ID record in the table
	private String code; // for storing Code record in the table
	private BigDecimal discount; // for storing discount record in the table
	private String expDate; // for storing expDate record in the table
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

}
