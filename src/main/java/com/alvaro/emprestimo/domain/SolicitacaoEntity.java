package com.alvaro.emprestimo.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class SolicitacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "solicitacao_seq")
    @SequenceGenerator(sequenceName = "solicitacao_seq", allocationSize = 1, name = "solicitacao_seq")
    private Long id;
    private BigDecimal valor;
    private LocalDateTime primeiraParcela;
    private int quantParcelas;

    @ManyToOne(fetch = FetchType.LAZY)
    private UsuarioEntity usuario;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getPrimeiraParcela() {
        return primeiraParcela;
    }

    public void setPrimeiraParcela(LocalDateTime primeiraParcela) {
        this.primeiraParcela = primeiraParcela;
    }

    public int getQuantParcelas() {
        return quantParcelas;
    }

    public void setQuantParcelas(int quantParcelas) {
        this.quantParcelas = quantParcelas;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
}
