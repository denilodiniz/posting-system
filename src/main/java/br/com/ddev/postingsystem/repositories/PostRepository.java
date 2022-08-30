package br.com.ddev.postingsystem.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ddev.postingsystem.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

	@Query("{date: {$gte: new Date('?0')}}")
	public List<Post> findByDateGreaterThanEqual(String date);
	
}
