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
			throw new ObjectNotFoundException("Object not found.");
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
	
	private UserDTO userToDto(User user) {
		UserDTO userDto = new UserDTO();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		return userDto;
	}
}
