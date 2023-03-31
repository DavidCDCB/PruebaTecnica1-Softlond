package com.cdcb.pruebatecnica1_softlond.repositories;

import java.util.List;

import com.cdcb.pruebatecnica1_softlond.exceptions.AccountNotFound;

public interface IRepository<T> {
	void connect();
	void createTable();
	void removeTable();
	void executeQuery(String query);
	void insert(T entity);
	List<T> selectAll();
	T selectById(int id) throws AccountNotFound;
	void update(T entity , int id) throws AccountNotFound;
	void delete(int id) throws AccountNotFound;
}
