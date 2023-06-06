package com.example.market.controller.base;

import com.example.market.model.response.ResponseData;
import com.example.market.model.base.BaseDTO;
import com.example.market.utils.BaseUtils;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * CRUD (Create, Read, Update, Delete)
 *
 * @param <CD> Create DTO
 * @param <E>  Entity
 * @param <K>  Key(identification)
 */
public interface GenericCRUDController<CD extends BaseDTO, E, K extends Serializable> {

    @RequestMapping(value = BaseUtils.CREATE_PATH, method = RequestMethod.POST)
    ResponseData<E> create(@RequestBody CD createDTO);

    @RequestMapping(value = BaseUtils.GET_PATH, method = RequestMethod.GET)
    ResponseData<E> get(@PathVariable K id);

    @RequestMapping(value = BaseUtils.LIST_PATH, method = RequestMethod.GET)
    ResponseData<List<E>> list();

    @RequestMapping(value = BaseUtils.UPDATE_PATH, method = RequestMethod.PUT)
    ResponseData<E> update(@RequestBody E updatingEntity);

    @RequestMapping(value = BaseUtils.DELETE_PATH, method = RequestMethod.DELETE)
    ResponseData<Boolean> delete(@PathVariable K id);
}
