/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fragusan.fragusan.Entity;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*private static String id;*/
    
    @NotNull
    @Size(min=3, max=50, message="Revise la longitud de la cadena *nombre*")
    private String nombre;
    @NotNull
    @Size(min=3, max=50, message="Revise la longitud de la cadena *apellido*")
    private String apellido;
    @NotNull
    @Size(min=3, max=50, message="Revise la longitud de la cadena *user*")
    private String user;
    @NotNull
    @Size(min=6, max=50, message="Revise la longitud de la cadena *email*")
    private String email;
    
    @Size( message="Revise url profile")
    private String picProfile;
    
    @Size(message="Revise url background")
    private String picBg;

    public Long getId() {
        return id;
    }
    /*public void setId() {
        this.id = java.util.UUID.randomUUID().toString();
    }*/
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicProfile() {
        return picProfile;
    }

    public void setPicProfile(String picProfile) {
        this.picProfile = picProfile;
    }

    public String getPicBg() {
        return picBg;
    }

    public void setPicBg(String picBg) {
        this.picBg = picBg;
    }
   
    
}
