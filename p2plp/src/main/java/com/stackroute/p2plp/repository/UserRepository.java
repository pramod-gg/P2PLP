package com.stackroute.p2plp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.p2plp.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
    
}
