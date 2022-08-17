package br.com.ddev.postingsystem.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.ddev.postingsystem.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
