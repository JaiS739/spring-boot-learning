package com.spring_security.security_practice.controllers;

import com.spring_security.security_practice.dto.ProductDTO;
import com.spring_security.security_practice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDTO> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public ProductDTO findProductById(@PathVariable Long id) {
        return productService.findProductById(id);
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductDTO product) {
        productService.createProduct(product);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Products saved successfully.");
    }
}
