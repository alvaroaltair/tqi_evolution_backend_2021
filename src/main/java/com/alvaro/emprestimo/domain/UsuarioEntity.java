package com.alvaro.emprestimo.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_usuarios")
public class UsuarioEntity {

    @Id
    private String usuario;
    private String senha;
    private boolean enabled;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<SolicitacaoEntity> solicitacoes;
}