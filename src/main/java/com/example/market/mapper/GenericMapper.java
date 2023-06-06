package com.example.market.mapper;

import com.example.market.model.base.BaseDTO;

/**
 * @param <E>  Entity
 * @param <CD> Create DTO
 */
public interface GenericMapper<E, CD extends BaseDTO> {

     E toEntity(CD createDTO);

}
