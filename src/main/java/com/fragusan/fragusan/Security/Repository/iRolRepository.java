package com.fragusan.fragusan.Security.Repository;


import com.fragusan.fragusan.Security.Entity.Rol;
import com.fragusan.fragusan.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre (RolNombre rolNombre);
}
