package br.com.ddev.postingsystem.resources;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ddev.postingsystem.dto.PostDTO;
import br.com.ddev.postingsystem.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	@GetMapping
	public ResponseEntity<List<PostDTO>> findByPostWithDateRange(
			@RequestParam(value = "firstDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate firstDate,
			@RequestParam(value = "secondDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate secondDate) {
		List<PostDTO> posts = service.findByPostWithDateRange(firstDate, secondDate);
		return ResponseEntity.ok().body(posts);
	}
	
}
