package com.fragusan.fragusan.Security.Entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrimary implements UserDetails {

    private String nombre;
    private String userName;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UserPrimary(String nombre, String userName, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.nombre = nombre;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserPrimary build(UsuarioDb user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name())).collect(Collectors.toList());
        return new UserPrimary(user.getNombre(), user.getUserName(), user.getEmail(), user.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
