package com.alvaro.emprestimo.repository;

import com.alvaro.emprestimo.domain.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, String> {

    UsuarioEntity findByUsername(String usuario);
}
