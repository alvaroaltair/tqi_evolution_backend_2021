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

    @NotBlank(message = "O campo não pode estar em branco")
    @Min(value = 1, message = "O valor da solicitação não pode ser zero.")
    private String valor;

    @NotBlank(message = "O campo não pode estar em branco.")
    @Min(value = 1, message = "O número de parcelas não pode ser zero.")
    @Max(value = 60, message = "O número de parcelas não pode ser maior que 60.")
    private String quantParcelas;

    @DataValid(message = "A data informada é inválida.")
    @ParcelaValid
    private String dataPrimeiraParcela;

    public SolicitacaoEntity toSolicitacao() {
        SolicitacaoEntity novaSolicitacao = new SolicitacaoEntity();
        //novaSolicitacao.setValor(BigDecimal.parseBigDecimal(valor));
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
