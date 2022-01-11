package com.alvaro.emprestimo.dto;

import com.alvaro.emprestimo.domain.SolicitacaoEntity;
import com.alvaro.emprestimo.validation.DataValid;
import com.alvaro.emprestimo.validation.ParcelaValid;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SolicitacaoDTO {

    @NotBlank
    @Min(value = 1)
    private String valor;

    @NotBlank
    @Min(value = 1)
    @Max(value = 60)
    private String quantParcelas;

    @DataValid
    @ParcelaValid
    private String dataPrimeiraParcela;

    public SolicitacaoEntity toSolicitacao() {
        SolicitacaoEntity novaSolicitacao = new SolicitacaoEntity();
        novaSolicitacao.setQuantParcelas(Integer.parseInt(quantParcelas));
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        novaSolicitacao.setPrimeiraParcela(LocalDateTime.parse(dataPrimeiraParcela, formatoData));
        return novaSolicitacao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getQuantParcelas() {
        return quantParcelas;
    }

    public void setQuantParcelas(String quantParcelas) {
        this.quantParcelas = quantParcelas;
    }

    public String getDataPrimeiraParcela() {
        return dataPrimeiraParcela;
    }

    public void setDataPrimeiraParcela(String dataPrimeiraParcela) {
        this.dataPrimeiraParcela = dataPrimeiraParcela;
    }
}
