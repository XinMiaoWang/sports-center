package com.ecommerce.sportscenter.model.dto;

import com.ecommerce.sportscenter.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private Integer id;
    private String name;
    private String description;
    private Long price;
    private String pictureUrl;
    private Integer productBrandId;
    private Integer productTypeId;

    public static ProductResponse convertToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .pictureUrl(product.getPictureUrl())
                .productBrandId(product.getProductBrandId())
                .productTypeId(product.getProductTypeId())
                .build();
    }
}
