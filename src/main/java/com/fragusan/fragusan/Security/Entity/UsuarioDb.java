package com.fragusan.fragusan.Security.Entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity
public class UsuarioDb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String nombre;
    @NotNull
    @Column(unique=true)
    private String userName;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "usuariodb_rol", joinColumns=@JoinColumn(name="usuariodb_id"), inverseJoinColumns=@JoinColumn(name="rol_id"))
    private Set<Rol> roles =new HashSet<>();

    public UsuarioDb() {
    }

    public UsuarioDb(String nombre, String userName, String email, String password) {
        this.nombre = nombre;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
    
    
    
    }
