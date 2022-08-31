package br.com.ddev.postingsystem.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.ddev.postingsystem.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

	public List<Post> findByDateGreaterThanEqual(LocalDate date);
	
}
