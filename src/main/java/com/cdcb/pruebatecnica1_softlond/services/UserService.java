package com.cdcb.pruebatecnica1_softlond.services;

import java.util.List;

import com.cdcb.pruebatecnica1_softlond.domain.User;
import com.cdcb.pruebatecnica1_softlond.exceptions.UserNotFound;
import com.cdcb.pruebatecnica1_softlond.repositories.IRepository;

public class UserService implements IService<User> {
	private IRepository<User> userRepository;

	public UserService(IRepository<User> userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void createDDL() {
		this.userRepository.createTable();
	}

	@Override
	public void removeDDL() {
		this.userRepository.removeTable();
	}

	@Override
	public void save(User entity) {
		this.userRepository.insert(entity);
	}

	@Override
	public List<User> getAll() {
		return this.userRepository.selectAll();
	}

	@Override
	public User getOne(int id) {
		try {
			return this.userRepository.selectById(id);
		} catch (UserNotFound e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean update(User entity, int id) {
		try {
			this.userRepository.update(entity, id);
			return true;
		} catch (UserNotFound e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean remove(int id) {
		try {
			this.userRepository.delete(id);
			return true;
		} catch (UserNotFound e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

}
