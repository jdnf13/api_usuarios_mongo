package com.mongo.mongo_serv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mongo.mongo_serv.model.Usuarios;
import com.mongo.mongo_serv.repository.UsersRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    public void save (Usuarios usuarios) {
        usersRepository.save(usuarios);
    }

    public List<Usuarios> findAll () {
        return usersRepository.findAll();
    }

    public Optional<Usuarios> findById (String id) {
        return usersRepository.findById(id);
    }

    public void deleteById (String id){
        usersRepository.deleteById(id);
    }
}
