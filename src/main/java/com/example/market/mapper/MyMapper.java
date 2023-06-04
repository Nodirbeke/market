package com.example.market.mapper;

import com.example.market.entity.BaseEntity;
import com.example.market.model.base.BaseDTO;

/**
 * @param <E>  Entity
 * @param <CD> Create DTO
 */
public interface MyMapper<E extends BaseEntity, CD extends BaseDTO> {

     E toEntity(CD createDTO);

}
