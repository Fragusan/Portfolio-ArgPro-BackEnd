package com.fragusan.fragusan.Security.Service;

import com.fragusan.fragusan.Security.Entity.UserPrimary;
import com.fragusan.fragusan.Security.Entity.UsuarioDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetalsImpl implements UserDetailsService {
    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioDb user= usuarioService.getByNombreUsuario(username).get();
        return UserPrimary.build(user);
    }
    
    
}
