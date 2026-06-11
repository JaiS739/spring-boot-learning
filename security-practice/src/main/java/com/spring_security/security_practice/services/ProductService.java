package com.spring_security.security_practice.services;

import com.spring_security.security_practice.dto.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface ProductService {
    ProductDTO findProductById(Long id);
    ProductDTO createProduct(ProductDTO productDTO);
}
