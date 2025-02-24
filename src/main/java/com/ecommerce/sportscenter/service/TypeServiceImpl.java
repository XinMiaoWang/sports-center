package com.ecommerce.sportscenter.service;

import com.ecommerce.sportscenter.entity.Type;
import com.ecommerce.sportscenter.model.dto.BrandResponse;
import com.ecommerce.sportscenter.model.dto.TypeResponse;
import com.ecommerce.sportscenter.repository.TypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TypeServiceImpl implements TypeService{

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public List<TypeResponse> getAllTypes() {
        List<Type> typeList = typeRepository.getAllTypes();
        List<TypeResponse> typeResponses = typeList.stream()
                .map(type -> TypeResponse.convertToTypeResponse(type))
                .collect(Collectors.toList());

        return typeResponses;
    }
}
