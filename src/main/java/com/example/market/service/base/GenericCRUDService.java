package com.example.market.service.base;

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
        E,
        K extends Serializable>  {

    E create(CD createDTO);

    E get(K key);

    List<E> list();

    E update(E updatingEntity);

    Boolean delete(K key);
}
