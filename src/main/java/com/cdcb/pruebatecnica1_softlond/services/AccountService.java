package com.cdcb.pruebatecnica1_softlond.services;

import java.util.List;

import com.cdcb.pruebatecnica1_softlond.domain.Account;
import com.cdcb.pruebatecnica1_softlond.exceptions.AccountNotFound;
import com.cdcb.pruebatecnica1_softlond.exceptions.RecordNotStored;
import com.cdcb.pruebatecnica1_softlond.repositories.AccountRepository;
import com.cdcb.pruebatecnica1_softlond.repositories.IRepository;

public class AccountService implements IService<Account> {
	private IRepository<Account> accountRepository;

	public AccountService(IRepository<Account> accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public void createDDL() {
		this.accountRepository.createTable();
	}

	@Override
	public void removeDDL() {
		this.accountRepository.removeTable();
	}

	@Override
	public boolean save(Account entity) {
		try {
			this.accountRepository.insert(entity);
			return true;
		} catch (RecordNotStored e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public List<Account> getAll() {
		return this.accountRepository.selectAll();
	}

	public List<Account> getByUser(int id) {
		return ((AccountRepository) this.accountRepository).selectByUser(id);
	}

	@Override
	public Account getOne(int id) {
		try {
			return this.accountRepository.selectById(id);
		} catch (AccountNotFound e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean update(Account entity, int id) {
		try {
			this.accountRepository.update(entity, id);
			return true;
		} catch (AccountNotFound e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean remove(int id) {
		try {
			this.accountRepository.delete(id);
			return true;
		} catch (AccountNotFound e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
}
