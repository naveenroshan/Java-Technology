package com.example.redisCache;

import entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;
import repo.ProductDAO;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/product")
@EnableCaching
public class SpringDataRedisExampleApplication {
    @Autowired
	private ProductDAO productDAO;

	@PostMapping
	public Product save(@RequestBody Product product){
		return productDAO.Save(product);
	}

	@GetMapping
	public List<Product> getAllProduct(){
		return productDAO.findAll();
	}

	@GetMapping("/{id}")
	@Cacheable(key = "#id", value = "Product", unless = "#result.price > 1000")
	public Product findProduct(@PathVariable int id){
		return productDAO.findProductById(id);
	}

	@DeleteMapping("/{id}")
	@CacheEvict
	public String remove(@PathVariable int id){
		return productDAO.deleteProduct(id);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRedisExampleApplication.class, args);
	}

}
