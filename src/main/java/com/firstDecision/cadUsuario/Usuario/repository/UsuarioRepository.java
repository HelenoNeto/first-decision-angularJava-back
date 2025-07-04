package com.firstDecision.cadUsuario.Usuario.repository;

import com.firstDecision.cadUsuario.Usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
