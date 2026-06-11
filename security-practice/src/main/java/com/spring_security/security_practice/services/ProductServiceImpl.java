package com.spring_security.security_practice.services;

import com.spring_security.security_practice.dto.ProductDTO;
import com.spring_security.security_practice.entities.ProductEntity;
import com.spring_security.security_practice.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService  {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public ProductDTO findProductById(Long id){
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No product found with product id " + id));
        return modelMapper.map(productEntity, ProductDTO.class);
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO){
        ProductEntity productEntity = modelMapper.map(productDTO, ProductEntity.class);
        ProductEntity savedProduct = productRepository.save(productEntity);
        return modelMapper.map(savedProduct, ProductDTO.class);
    }
}
