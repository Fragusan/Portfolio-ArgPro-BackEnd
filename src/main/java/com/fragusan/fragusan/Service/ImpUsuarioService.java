package com.fragusan.fragusan.Service;

import com.fragusan.fragusan.Entity.Usuario;
import com.fragusan.fragusan.Interface.IUsuarioService;
import com.fragusan.fragusan.Repository.IUserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpUsuarioService implements IUsuarioService {
@Autowired IUserRepository iusuarioRepository;
    
    @Override
    public List<Usuario> getUsuario() {
        List<Usuario> data= iusuarioRepository.findAll();
        return data;
    }

    @Override
    public void saveUsuario(Usuario user) {
        iusuarioRepository.save(user);
    }

    @Override
    public void delUsuario(Long id) {
        iusuarioRepository.deleteById(id);
    }

    @Override
    public Usuario findUsuaario(Long id) {
        Usuario data=iusuarioRepository.findById(id).orElse(null);
        return data;
    }
    
}
