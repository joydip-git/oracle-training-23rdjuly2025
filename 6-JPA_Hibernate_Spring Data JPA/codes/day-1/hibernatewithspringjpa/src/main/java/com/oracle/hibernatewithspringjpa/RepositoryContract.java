package com.oracle.hibernatewithspringjpa;

import java.util.List;

public interface RepositoryContract<T,TId> {
		boolean save(T data);
		boolean update(TId id, T data) throws Exception;
		boolean delete(TId id) throws Exception;
		List<T> getAll();
		T get(TId id) throws Exception;
}
