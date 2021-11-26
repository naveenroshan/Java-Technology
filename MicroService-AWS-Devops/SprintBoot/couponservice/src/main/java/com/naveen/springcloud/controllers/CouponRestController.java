package com.naveen.springcloud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.naveen.springcloud.model.Coupon;
import com.naveen.springcloud.repos.CouponRepo;

@RestController
@RequestMapping("/couponApi")
public class CouponRestController {
	
	// Injecting the interface coupon repo for implementation
	@Autowired
	CouponRepo repo;
	
	// creating a coupon given from client and storing in the DB
	@RequestMapping(value = "/coupons", method = RequestMethod.POST)
	public Coupon create(@RequestBody Coupon coupon) {
		return repo.save(coupon);
	}

	// get the coupon from the data base which the client requested code
	@RequestMapping(value = "/coupons/{code}", method = RequestMethod.GET)
	public Coupon getCoupon(@PathVariable("code") String code) {
		return repo.findByCode(code);		
	}	
}
