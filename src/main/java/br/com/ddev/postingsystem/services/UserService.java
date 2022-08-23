package br.com.ddev.postingsystem.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ddev.postingsystem.domain.Post;
import br.com.ddev.postingsystem.domain.User;
import br.com.ddev.postingsystem.dto.PostDTO;
import br.com.ddev.postingsystem.dto.UserDTO;
import br.com.ddev.postingsystem.repositories.UserRepository;
import br.com.ddev.postingsystem.services.exceptions.NoContentException;
import br.com.ddev.postingsystem.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PostService postService;

	public UserDTO findById(String id) {
		if (repository.existsById(id)) {
			User user = repository.findById(id).get();
			UserDTO userDto = new UserDTO();
			userDto.setId(user.getId());
			userDto.setName(user.getName());
			userDto.setEmail(user.getEmail());
			userDto.setIdPosts(user.getPosts().stream().map(x -> x.getId()).toList());;
			return userDto;
		}
		else {
			throw new ObjectNotFoundException("User with ID " + id + " does not exist");
		}
	}

	public List<UserDTO> findAll() {
		if (!repository.findAll().isEmpty()) {
			List<User> listUsers = repository.findAll();
			List<UserDTO> listUsersDto = new ArrayList<>();
			for (User user : listUsers) {
				UserDTO userDto = new UserDTO();
				userDto.setId(user.getId());
				userDto.setName(user.getName());
				userDto.setEmail(user.getEmail());
				listUsersDto.add(userDto);
			}
			return listUsersDto;
		}
		else {
			throw new NoContentException();
		}
	}
	
	public List<PostDTO> findAllPostsForIdUser(String id) {
		User user = repository.findById(id).get();
		List<Post> listPost = user.getPosts();
		List<PostDTO> listPostDto = new ArrayList<>();
		for (Post post : listPost) {
			PostDTO postDto = new PostDTO(post);
			postDto.setAuthor(null);
			listPostDto.add(postDto);
		}
		return listPostDto;
	}
	
	public PostDTO findPostByIDForIdUser(String idUser, String idPost) {
		PostDTO postDto = postService.findById(idPost);
		postDto.setAuthor(null);
		return postDto;	
	}
	
	public User insert(UserDTO userDto) {
		return repository.save(dtoToUser(userDto));
	}
	
	public void delete(String id) {
		findById(id);//caso o usuário não exista ele retorna uma exceção e da breake no metodo
		repository.deleteById(id);
	}
	
	public User updata(UserDTO userDto) {
		findById(userDto.getId());//caso o usuário não exista ele retorna uma exceção e da breake no metodo
		User userData = dtoToUser(userDto);
		User userUpdate = repository.findById(userData.getId()).get();
		updataData(userUpdate, userData);
		return repository.save(userUpdate);
	}
	
	/*private UserDTO userToDto(User user) {
		return new UserDTO(user);
	}*/
	
	private User dtoToUser(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}
	
	private void updataData(User userUpdate, User userData) {
		userUpdate.setName(userData.getName());
		userUpdate.setEmail(userData.getEmail());
	}
}
