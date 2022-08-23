package br.com.ddev.postingsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ddev.postingsystem.dto.PostDTO;
import br.com.ddev.postingsystem.repositories.PostRepository;
import br.com.ddev.postingsystem.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public PostDTO findById(String id) {
		if (repository.existsById(id)) {
			PostDTO postDto = new PostDTO(repository.findById(id).get());
			return postDto;
		}
		else {
			throw new ObjectNotFoundException("Post with ID " + id + " does not exist");
		}
	}
	
}
