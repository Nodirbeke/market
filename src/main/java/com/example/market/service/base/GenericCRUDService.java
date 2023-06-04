package com.example.market.service.base;

import com.example.market.entity.BaseEntity;
import com.example.market.model.base.BaseDTO;

import java.io.Serializable;
import java.util.List;

/**
 * CRUD (Create, Read, Update, Delete)
 *
 * @param <CD> Create DTO
 * @param <E>  Entity
 * @param <K>  Key(identification)
 */
public interface GenericCRUDService<CD extends BaseDTO,
        E extends BaseEntity,
        K extends Serializable>  {

    E create(CD DTO);

    E get(K key);

    List<E> list();

    E update(E DTO);

    Boolean delete(K key);
}
