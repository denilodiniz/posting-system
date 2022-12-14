package br.com.ddev.postingsystem.resources;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ddev.postingsystem.dto.PostDTO;
import br.com.ddev.postingsystem.resources.util.DecodeUrl;
import br.com.ddev.postingsystem.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	@GetMapping
	public ResponseEntity<List<PostDTO>> findByDateGreaterThanEqual(
			@RequestParam(value = "date", defaultValue = "2022-01-01") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		List<PostDTO> posts = service.findByDateGreaterThanEqual(date);
		return ResponseEntity.ok().body(posts);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PostDTO> findById(@PathVariable String id) {
		PostDTO postDto = service.findById(id);
		return ResponseEntity.ok().body(postDto);
	}
	
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<PostDTO>> findAllTitleContaining(@RequestParam(value = "text", defaultValue = "") String text) {
		text = DecodeUrl.decodeParam(text);
		List<PostDTO> posts = service.findByBodyContainig(text);
		return ResponseEntity.ok().body(posts);
	}
	
	@GetMapping(value = "/bodysearch")
	public ResponseEntity<List<PostDTO>> findPostsWithTextInBody(@RequestParam(value = "text", defaultValue = "") String text) {
		text = DecodeUrl.decodeParam(text);
		List<PostDTO> posts = service.findPostsWithTextInBody(text);
		return ResponseEntity.ok().body(posts);
	}
	
	@GetMapping(value = "titledate")
	public ResponseEntity<List<PostDTO>> findPostsWithRangeDateAndTextInPost(
			@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "firstDate", defaultValue = "2022-01-01") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate firstDate,
			@RequestParam(value = "lastDate", defaultValue = "2022-01-01") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate lastDate) {
		text = DecodeUrl.decodeParam(text);
		List<PostDTO> posts = service.findPostsWithRangeDateAndTextInPost(text, firstDate, lastDate);
		return ResponseEntity.ok().body(posts);
	}
	
}
