package com.product.module.product.controllers;

import com.product.module.product.entities.ProductEntity;
import com.product.module.product.repositories.ProductRepositories;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/products")
public class ProductController {
   private final ProductRepositories productRepositories;

   private final int PAGE_SIZE = 5;

   public ProductController(ProductRepositories productRepositories){
       this.productRepositories = productRepositories;
   }

//   @GetMapping
//    public List<ProductEntity> getAllProducts () {
//       return productRepositories.findByOrderByPrice();
//   }

    @GetMapping
    public List<ProductEntity> getAllProducts(@RequestParam (defaultValue = "id") String sortBy){
        return productRepositories.findBy(Sort.by(Sort.Direction.DESC, sortBy));
    }

    @GetMapping("/{id}")
    public  ProductEntity getProductsById(@PathVariable String id){
       return productRepositories.findById(id);
    }

//    pagination

    @GetMapping("/pagination")
    public List<ProductEntity> getPaginatedProducts(@RequestParam (defaultValue = "0") int pageNumber ){
        Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE);
        return productRepositories.findAll(pageable).getContent();
    }
}