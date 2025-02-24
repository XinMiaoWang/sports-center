package com.ecommerce.sportscenter.repository;

import com.ecommerce.sportscenter.entity.Brand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Slf4j
public class BrandRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<Brand> getAllBrands() {
        try {
            String sql = "select id, name from brand";
            List<Brand> brandList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Brand.class));

            log.info("Get all brands: {}", brandList.toString());
            return brandList;
        } catch (Exception e) {
            return null;
        }
    }
}
