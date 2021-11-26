package com.naveen.springcloud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.naveen.springcloud.dto.Coupon;
import com.naveen.springcloud.model.Product;
import com.naveen.springcloud.repos.ProductRepo;

@RestController
@RequestMapping("/productApi")
public class ProductRestController {

	// Injecting the interface product repo for implementation
	@Autowired
	ProductRepo repo;
	
	// getting the coupon code from coupon service for client
	@Autowired
	RestTemplate restTemplate;
	
	//getting the url from application properties file
	@Value("${couponService.URL}")
	String couponServiceURL;
	
	// creating a products given from client and storing in the DB
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public Product create(@RequestBody Product product) {
		// requesting the coupon service for the coupons
		Coupon coupon = restTemplate.getForObject(couponServiceURL + product.getCouponCode(), Coupon.class);
		//apply the discount logic 
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return repo.save(product);
	}
}
