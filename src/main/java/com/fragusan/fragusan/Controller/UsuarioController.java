package com.fragusan.fragusan.Controller;

import com.fragusan.fragusan.Entity.Usuario;
import com.fragusan.fragusan.Exception.ResourceNotFoundException;
import com.fragusan.fragusan.Interface.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UsuarioController {
    @Autowired IUsuarioService iusuarioServicio;
    
    public Usuario item;
    
    @GetMapping("/user/getAll")
    public List <Usuario> getUser(){
        return iusuarioServicio.getUsuario();
    }
    
    @PostMapping("/user/new")
    public String newUser(@RequestBody Usuario user){
    /*Usuario nuevo=user;
    nuevo.setId();*/
    try{
        iusuarioServicio.saveUsuario(user);
        return "El nueveo usuario fue creado de manera satisfactoriamente";
    }catch(Exception e){
        return "se produjo un error inesperado intentando crear el usuario";
        }
    }
    
    @DeleteMapping("/user/del{id}")
    public String deleteUser(@PathVariable Long id){
    try{
        iusuarioServicio.delUsuario(id);
        return "Se elimino al usuario id:" + id.toString();
    }catch(Exception e){
        return "No se realizo la elminación debido a un error";
        } 
    }
    
    @PutMapping("/user{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario update){
    Usuario old=iusuarioServicio.findUsuaario(id);
    old.setNombre(update.getNombre());
        old.setApellido(update.getApellido());
        old.setUser(update.getUser());
        old.setEmail(update.getEmail());
        old.setPicProfile(update.getPicProfile());
        old.setPicBg(update.getPicBg());
        iusuarioServicio.saveUsuario(old);
    return old;
    }
}
