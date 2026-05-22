package com.product.module.product;

import com.product.module.product.entities.ProductEntity;
import com.product.module.product.repositories.ProductRepositories;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ApplicationTests {

	@Autowired
	ProductRepositories productRepositories;

	@Test
	void contextLoads() {
	}

//	@Test
//	void testRepository() {
//		ProductEntity productEntity = ProductEntity.builder()
//				.sku("Nestle")
//				.title("Nestle Chocolate")
//				.price(BigDecimal.valueOf(123.45))
//				.quantity(12)
//				.build();
//
//		ProductEntity savedProductEntity = productRepositories.save(productEntity);
//		System.out.println(savedProductEntity);
//	}

	@Test
	void getByTitle() {
		List<ProductEntity> listByTitle = productRepositories.findByTitle("Nestle Chocolate");
		System.out.println(listByTitle);
	}

}
