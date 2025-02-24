package com.ecommerce.sportscenter.model.dto;

import com.ecommerce.sportscenter.entity.Brand;
import com.ecommerce.sportscenter.entity.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TypeResponse {
    private Integer id;
    private String name;

    public static TypeResponse convertToTypeResponse(Type type) {
        return TypeResponse.builder()
                .id(type.getId())
                .name(type.getName())
                .build();
    }
}
