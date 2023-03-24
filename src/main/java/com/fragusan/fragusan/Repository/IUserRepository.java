package com.fragusan.fragusan.Repository;

import com.fragusan.fragusan.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 @Repository
public interface IUserRepository extends JpaRepository<Usuario, Long> {
    
}
