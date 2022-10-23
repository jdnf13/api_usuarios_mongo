package com.mongo.mongo_serv.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongo.mongo_serv.model.Usuarios;

@Repository
public interface UsersRepository extends MongoRepository <Usuarios, String> {
    
}
