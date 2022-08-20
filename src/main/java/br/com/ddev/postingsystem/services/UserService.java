package br.com.ddev.postingsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ddev.postingsystem.domain.User;
import br.com.ddev.postingsystem.dto.UserDTO;
import br.com.ddev.postingsystem.repositories.UserRepository;
import br.com.ddev.postingsystem.services.exceptions.NoContentException;
import br.com.ddev.postingsystem.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public UserDTO findById(String id) {
		if (repository.existsById(id)) {
			return userToDto(repository.findById(id).get());
		}
		else {
			throw new ObjectNotFoundException("No user found with id: " + id);
		}
	}

	public List<UserDTO> findAll() {
		if (!repository.findAll().isEmpty()) {
			List<User> users = repository.findAll();
			List<UserDTO> usersDto = users.stream().map(x -> new UserDTO(x)).toList();
			return usersDto;
		}
		else {
			throw new NoContentException();
		}
	}
	
	public User insert(UserDTO userDto) {
		return repository.save(dtoToUser(userDto));
	}
	
	private UserDTO userToDto(User user) {
		return new UserDTO(user);
	}
	
	private User dtoToUser(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}
}
