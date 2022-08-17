package br.com.ddev.postingsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ddev.postingsystem.domain.User;
import br.com.ddev.postingsystem.repositories.UserRepository;
import br.com.ddev.postingsystem.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Object not found."));
	}

	public List<User> findAll() {
		return repository.findAll();
	}
}
