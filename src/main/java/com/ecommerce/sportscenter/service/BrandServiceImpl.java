package com.ecommerce.sportscenter.service;

import com.ecommerce.sportscenter.entity.Brand;
import com.ecommerce.sportscenter.model.dto.BrandResponse;
import com.ecommerce.sportscenter.repository.BrandRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BrandServiceImpl implements BrandService{
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<BrandResponse> getAllBrands() {
        List<Brand> brandList = brandRepository.getAllBrands();
        List<BrandResponse> brandResponses = brandList.stream()
                .map(brand -> BrandResponse.convertToBrandResponse(brand))
                .collect(Collectors.toList());

        return brandResponses;
    }
}
