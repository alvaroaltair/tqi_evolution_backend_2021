package com.alvaro.emprestimo.repository;

import com.alvaro.emprestimo.domain.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastroUsuarioRepository extends JpaRepository<ClienteEntity, Long> {

    @Query("select p from Cliente p where p.email = :email")
    ClienteEntity findByEmail(@Param("email") String email);

}