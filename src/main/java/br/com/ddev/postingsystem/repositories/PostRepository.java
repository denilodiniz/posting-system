package br.com.ddev.postingsystem.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ddev.postingsystem.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

	public List<Post> findByDateGreaterThanEqual(LocalDate date);
	
	public List<Post> findByTitleContainingIgnoreCase(String text);
	
	@Query("{ body: {$regex: ?0, $options: 'i' } }")
	public List<Post> findPostsWithTextInBody(String text);
	
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { title: { $regex: ?0, $options: 'i' } }, { body: { $regex: ?0, $options: 'i' } }, { comments.text: { $regex: ?0, $options: 'i' } } ] } ] }")
	public List<Post> findPostsWithRangeDateAndTextInPost(String text, LocalDate firstDate, LocalDate lastDate);
	
}
