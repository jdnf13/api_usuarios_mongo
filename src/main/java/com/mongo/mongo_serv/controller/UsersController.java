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
        if(usersService.findById(id).isPresent()){
            return usersService.findById(id).get();
        }else{
            return null;
        }
    }

    @DeleteMapping("/usuario_eliminar/{id}")
    public String deleteById(@PathVariable String id){
        boolean exist = usersService.findById(id).isPresent();
        if(exist){
            usersService.deleteById(id);
            System.out.println("Entramos a Eliminar");
            boolean usr = usersService.findById(id).isPresent();
            if(usr){
                return "No fue posible eliminar el usuario";
            }else{
                return "Se elimino el usuario correctamente";
            }
        }else{
            return "El registro no existe";
        }
    }

    @PutMapping("/usuario_modificar")
    public String update(@RequestBody Usuarios usuarios){
        boolean usr = usersService.findById(usuarios.getId()).isPresent();
        if(usr){
          System.out.println("Entramos a Actualizar");
          usersService.save(usuarios);
          return "Resgistro actualizado";
        }else{
            return "El registro no existe";
        }
    }
}
