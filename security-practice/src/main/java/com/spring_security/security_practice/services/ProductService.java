package com.spring_security.security_practice.services;

import com.spring_security.security_practice.dto.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    ProductDTO findProductById(Long id);
    ProductDTO createProduct(ProductDTO productDTO);
    List<ProductDTO> getProducts();
}
