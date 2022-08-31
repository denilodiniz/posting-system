package br.com.ddev.postingsystem.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ddev.postingsystem.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

	@Query("db.getCollection('post').find({date: {$gte: ISODate(\"?0\"), $lte: ISODate(\"?1\")}})")
	public List<Post> findByPostWithDateRange(LocalDate firstDate, LocalDate secondDate);
	
}
