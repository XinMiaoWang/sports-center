package com.ecommerce.sportscenter.entity;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Brand {
    private Integer id;
    private String name;
//    private List<Product> products;
}
