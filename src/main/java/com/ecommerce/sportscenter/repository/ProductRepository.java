package com.ecommerce.sportscenter.repository;

import com.ecommerce.sportscenter.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class ProductRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public Product getProductById(Integer productId) {
        String sql = "SELECT id, name, description, price, pictureUrl, productBrandId, productTypeId FROM product WHERE id = :productId";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("productId", productId);

        try {
            Product product = jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(Product.class));
            log.info("Product: {}", product.toString());
            return product;
        } catch (Exception e) {

        }
        return null;
    }

    public List<Product> getProducts() {
        String sql = "SELECT id, name, description, price, pictureUrl, productBrandId, productTypeId FROM product";

        List<Product> products = jdbcTemplate.query(sql, (rs, rowNum) -> new Product(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getLong("price"),
                rs.getString("pictureUrl"),
                rs.getInt("productBrandId"),
                rs.getInt("productTypeId")
        ));

        return products;
    }
}
