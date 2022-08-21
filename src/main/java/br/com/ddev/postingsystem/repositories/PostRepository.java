package br.com.ddev.postingsystem.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.ddev.postingsystem.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
