package com.oracle.productapiservice;

import java.sql.SQLException;
import java.util.List;

public interface DaoContract<T, TId> {
	int add(T data) throws ClassNotFoundException, SQLException, Exception;

	int delete(TId id) throws ClassNotFoundException, SQLException, Exception;

	int update(TId id, T data) throws ClassNotFoundException, SQLException, Exception;

	List<T> getAll() throws ClassNotFoundException, SQLException, Exception;

	T get(TId id) throws ClassNotFoundException, SQLException, Exception;
}
