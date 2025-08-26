package com.oracle.helidon.pmsapp.repository;

import java.util.List;

public interface RepositoryContract<T, TId> {
    T add(T data);

    T delete(TId id) throws Exception;

    T get(TId id);

    List<T> getAll();

    T update(TId id, T data) throws Exception;
}
