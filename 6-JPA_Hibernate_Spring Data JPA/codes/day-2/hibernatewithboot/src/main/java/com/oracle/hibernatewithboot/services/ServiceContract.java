package com.oracle.hibernatewithboot.services;

public interface ServiceContract<T, TId> {
	T add(T data);
	T update(TId id, T data);
	boolean delete(TId id);
	Iterable<T> getAll();
	T get(TId id);
}
