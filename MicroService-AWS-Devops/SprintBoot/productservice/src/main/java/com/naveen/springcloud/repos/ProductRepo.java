package com.naveen.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naveen.springcloud.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
