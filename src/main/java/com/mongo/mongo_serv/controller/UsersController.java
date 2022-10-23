package com.mongo.mongo_serv.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mongo.mongo_serv.model.Usuarios;
import com.mongo.mongo_serv.service.UsersService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users/v1")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @PostMapping("/guardar")
    public void save (@RequestBody Usuarios usuarios) {
        usersService.save(usuarios);
    }

    @GetMapping("/todos")
    public List<Usuarios> findAll(){
        return usersService.findAll();
    }

    @GetMapping("/usuario_id/{id}")
    public Usuarios findById(@PathVariable String id) {
        return usersService.findById(id).get();
    }

    @DeleteMapping("/usuario_eliminar/{id}")
    public void deleteById(@PathVariable String id){
        Usuarios usr = usersService.findById(id).get();
        if(usr != null){
            System.out.println("Entramos a Eliminar");
            usersService.deleteById(id);
        }
    }

    @PutMapping("/usuario_modificar")
    public void update(@RequestBody Usuarios usuarios){
        Usuarios usr = usersService.findById(usuarios.getId()).get();
        if(usr != null){
          System.out.println("Entramos a Actualizar");
          usersService.save(usuarios);
        }
    }
}
