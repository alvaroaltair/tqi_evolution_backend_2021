package com.alvaro.emprestimo.repository;

import com.alvaro.emprestimo.domain.SolicitacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SolicitacaoRepository extends JpaRepository<SolicitacaoEntity, Long> {

    @Query("select p from SolicitacaoEntity p join p.user u where u.username = :username")
    List<SolicitacaoEntity> findAllByUsuario(@Param("username") String usuario);

}
