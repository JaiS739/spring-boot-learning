package com.product.module.product.repositories;

import com.product.module.product.entities.ProductEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepositories extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByTitle(String title);

//    List<ProductEntity> findByOrderByPrice(); sorting by price
    // if we want to sort by other parameters as well then we have to write a lot of codes
//    so making it dynamic

    List<ProductEntity> findBy(Sort sort);

    ProductEntity findById(String id);

}
