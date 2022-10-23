package com.mongo.mongo_serv.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(value = "Usuarios")
@Data
public class Usuarios {
    
    @Id
    private String id;

    private String name;
    private String lastname;
    private String mail;
    private String password;
    private String rol;

    /* el paquete lombok genera automaticamente los setters y getters sin necesidad de escribirlos
    public Usuarios(){
        super();
    }

    public Usuarios(String id, String name, String lastname, String mail, String password, String rol){
        super();
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.mail = mail;
        this.password = password;
        this.rol = rol;
    }

    /**Setters 
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    /**Getters 
    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getLastname(){
        return lastname;
    }

    public String getMail(){
        return mail;
    }

    public String getPassword(){
        return password;
    }

    public String getRol(){
        return rol;
    }*/


}
