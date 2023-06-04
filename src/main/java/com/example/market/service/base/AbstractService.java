package com.example.market.service.base;

import com.example.market.repository.BaseRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractService<R extends BaseRepository> implements BaseService {
    protected final R repository;
}
