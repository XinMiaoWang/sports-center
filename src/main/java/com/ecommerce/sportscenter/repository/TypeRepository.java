package com.ecommerce.sportscenter.repository;

import com.ecommerce.sportscenter.entity.Type;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class TypeRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<Type> getAllTypes() {
        try {
            String sql = "select id, name from type";
            List<Type> typeList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Type.class));
            log.info("Get all types: {}", typeList.toString());
            return typeList;
        } catch (Exception e) {
            return null;
        }
    }
}
