package br.com.ddev.postingsystem.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ddev.postingsystem.domain.Post;
import br.com.ddev.postingsystem.dto.PostDTO;
import br.com.ddev.postingsystem.repositories.PostRepository;
import br.com.ddev.postingsystem.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public PostDTO findById(String id) {
			return createPostDtoWithAuthor(repository.findById(id)
					.orElseThrow(() -> new ObjectNotFoundException("Post with ID " + id + " does not exist")));
	}
	
	public List<PostDTO> findAll() {
			List<PostDTO> listPostDto = repository.findAll().stream()
					.map(x -> createPostDto(x))
					.toList();
			return listPostDto;	
	}
	
	public List<PostDTO> findByDateGreaterThanEqual(LocalDate date) {
		List<PostDTO> posts = repository.findByDateGreaterThanEqual(date)
				.stream()
				.map(x -> this.createPostDto(x))
				.toList();
		return posts;
	}
	
	public PostDTO createPostDto(Post post) {
		PostDTO postDto = new PostDTO();
		postDto.setId(post.getId());
		postDto.setDate(post.getDate());
		postDto.setTitle(post.getTitle());
		postDto.setBody(post.getBody());
		postDto.setComments(post.getComments());
		return postDto;
	}
	
	public PostDTO createPostDtoWithAuthor(Post post) {
		return new PostDTO(post);
	}
	
}
