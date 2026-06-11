package com.spring_security.security_practice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {
    private String category;

    private String productName;

    private Integer price;

    private Integer rating;

    private String description;
}
