package com.alvaro.emprestimo.dto;

import com.alvaro.emprestimo.domain.ClienteEntity;
import com.alvaro.emprestimo.validation.EmailValid;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class UsuarioDTO {
    @NotBlank(message = "O nome não pode estar em branco")
    private String nome;

    @NotBlank(message = "O e-mail não pode estar em branco")
    @EmailValid
    @Email
    private String email;

    @NotBlank(message = "A senha não pode estar em branco")
    private String senha;

    @NotBlank(message = "O RG não pode estar em branco")
    private String rg;

    @NotBlank(message = "O CPF não pode estar em branco")
    @CPF(message = "Informe um CPF válido")
    private String cpf;

    @NotBlank(message = "A renda não pode estar em branco")
    @Min(value = 1, message = "A renda não pode ser zero")
    private String renda;

    @NotBlank(message = "O endereço não pode estar em branco")
    private String endereco;

    @NotBlank(message = "O complemento não pode estar em branco")
    private String complemento;

    public ClienteEntity toUsuario() {
        ClienteEntity novoCliente = new ClienteEntity();

        novoCliente.setNome(nome);
        novoCliente.setEmail(email);
        novoCliente.setCpf(cpf);
        novoCliente.setRg(rg);
        novoCliente.setEndereco(endereco);
        // novoCliente.setRenda(Float.parseFloat(renda));-
        novoCliente.setSenha(senha);

        return novoCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRenda() {
        return renda;
    }

    public void setRenda(String renda) {
        this.renda = renda;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}