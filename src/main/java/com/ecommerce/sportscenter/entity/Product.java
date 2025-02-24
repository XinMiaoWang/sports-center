package com.ecommerce.sportscenter.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private Integer id;
    private String name;
    private String description;
    private Long price;
    private String pictureUrl;
    private Integer productBrandId;
    private Integer productTypeId;
}
