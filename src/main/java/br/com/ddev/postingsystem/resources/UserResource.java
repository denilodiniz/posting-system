package br.com.ddev.postingsystem.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ddev.postingsystem.dto.PostDTO;
import br.com.ddev.postingsystem.dto.UserDTO;
import br.com.ddev.postingsystem.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<UserDTO> listDto = service.findAll();
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		UserDTO user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping(value = "/{id}/posts")
	public ResponseEntity<List<PostDTO>> findAllPostsForIdUser(@PathVariable String id) {
		List<PostDTO> listPostDto = service.findAllPostsWithIdUser(id);
		return ResponseEntity.ok().body(listPostDto);
	}
	
	@GetMapping(value = "/{idUser}/posts/{idPost}")
	public ResponseEntity<PostDTO> findPostByIDForIdUser(@PathVariable String idUser,@PathVariable String idPost) {
		PostDTO postDto = service.findPostByIdWithIdUser(idUser, idPost);
		return ResponseEntity.ok().body(postDto);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO userDto) {
		service.insert(userDto);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(userDto.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UserDTO> updata(@RequestBody UserDTO userDto, @PathVariable String id) {
		userDto.setId(id);
		service.updata(userDto);
		return ResponseEntity.noContent().build();
	}
	
}
