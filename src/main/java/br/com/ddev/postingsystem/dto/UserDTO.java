package br.com.ddev.postingsystem.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.ddev.postingsystem.domain.Post;
import br.com.ddev.postingsystem.domain.User;

@JsonInclude(Include.NON_NULL)
public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	
	private List<Post> posts;
	private List<String> idPosts;
	
	public UserDTO() {
	}
	
	public UserDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
		posts = obj.getPosts();
		idPosts = obj.getPosts().stream().map(x -> x.getId()).toList();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Post> getPosts() {
		return posts;
	}
	
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<String> getIdPosts() {
		return idPosts;
	}

	public void setIdPosts(List<String> idPosts) {
		this.idPosts = idPosts;
	}
	
}
