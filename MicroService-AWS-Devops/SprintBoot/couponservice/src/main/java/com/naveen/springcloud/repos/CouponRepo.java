package com.naveen.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naveen.springcloud.model.Coupon;

// this interface is used to perform the quered operation in the mysql table coupon.
public interface CouponRepo extends JpaRepository<Coupon, Long> {

	//this spring method from user define method performance the select query coupon base on the code.
	Coupon findByCode(String code);
}
