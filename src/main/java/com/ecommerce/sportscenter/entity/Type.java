package com.ecommerce.sportscenter.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Type {
    private Integer id;
    private String name;
    private List<Product> prodcts;
}
