package com.cdcb.pruebatecnica1_softlond.services;

import java.util.List;

import com.cdcb.pruebatecnica1_softlond.domain.Transaction;
import com.cdcb.pruebatecnica1_softlond.exceptions.TransactionNotFound;
import com.cdcb.pruebatecnica1_softlond.repositories.IRepository;
import com.cdcb.pruebatecnica1_softlond.repositories.TransactionRepository;

public class TransactionService implements IService<Transaction> {
	private IRepository<Transaction> transactionRepository;

	public TransactionService(IRepository<Transaction> userRepository) {
		this.transactionRepository = userRepository;
	}

	@Override
	public void createDDL() {
		this.transactionRepository.createTable();
	}

	@Override
	public void removeDDL() {
		this.transactionRepository.removeTable();
	}

	@Override
	public void save(Transaction entity) {
		this.transactionRepository.insert(entity);
		
	}

	@Override
	public List<Transaction> getAll() {
		return this.transactionRepository.selectAll();
	}

	public List<Transaction> getByAccount(int id) {
		return ((TransactionRepository) this.transactionRepository).selectByAccount(id);
	}

	@Override
	public Transaction getOne(int id) {
		try {
			return this.transactionRepository.selectById(id);
		} catch (TransactionNotFound e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean update(Transaction entity, int id) {
		try {
			this.transactionRepository.update(entity, id);
			return true;
		} catch (TransactionNotFound e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean remove(int id) {
		try {
			this.transactionRepository.delete(id);
			return true;
		} catch (TransactionNotFound e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
