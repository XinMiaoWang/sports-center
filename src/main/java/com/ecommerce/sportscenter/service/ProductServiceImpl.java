package com.ecommerce.sportscenter.service;


import com.ecommerce.sportscenter.entity.Product;
import com.ecommerce.sportscenter.model.dto.ProductResponse;
import com.ecommerce.sportscenter.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductResponse getProductById(Integer productId) {
        log.info("Get Product by Id: {}", productId);
        Product product = productRepository.getProductById(productId);
        ProductResponse productResponse = ProductResponse.convertToProductResponse(product);
        return productResponse;
    }

    @Override
    public List<ProductResponse> getProducts() {
        log.info("Get all products");
        List<Product> products = productRepository.getProducts();
        log.info("Products: {}", products.toString());

        List<ProductResponse> productResponse = products
                .stream()
                .map((product) -> ProductResponse.convertToProductResponse(product))
                .collect(Collectors.toList());

        return productResponse;
    }
}
