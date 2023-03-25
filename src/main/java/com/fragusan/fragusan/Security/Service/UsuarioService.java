package com.fragusan.fragusan.Security.Service;

import com.fragusan.fragusan.Security.Entity.UsuarioDb;
import com.fragusan.fragusan.Security.Repository.iUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    iUsuarioRepository iusuarioRepository;

public Optional<UsuarioDb> getByNombreUsuario(String nombreUsuario){
    return iusuarioRepository.findByNombreUsuario(nombreUsuario);
}

public boolean existsByNombreUsuario(String nombreUsuario){
    return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
}

public boolean existsByEmail(String Email){
    return iusuarioRepository.existsByEmail(Email);
}

public void save(UsuarioDb user){
iusuarioRepository.save(user);
}

}

