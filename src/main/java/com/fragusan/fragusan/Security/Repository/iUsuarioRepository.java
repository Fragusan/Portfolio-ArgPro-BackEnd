
package com.fragusan.fragusan.Security.Repository;

import com.fragusan.fragusan.Security.Entity.UsuarioDb;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iUsuarioRepository extends JpaRepository<UsuarioDb,Integer> {
    Optional<UsuarioDb> findByNombreUsuario(String nombreUsuario);
    
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);
}
