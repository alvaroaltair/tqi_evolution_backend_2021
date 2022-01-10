package com.alvaro.emprestimo.validation;

import com.alvaro.emprestimo.domain.ClienteEntity;
import com.alvaro.emprestimo.repository.CadastroUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailValid, String> {

    @Autowired
    CadastroUsuarioRepository cadastroUsuarioRepository;

    @Override
    public void initialize(EmailValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean flag = false;
        var listaUsuarios = cadastroUsuarioRepository.findAll();
        for (ClienteEntity usuario : listaUsuarios) {
            if (s.equals(usuario.getEmail())) {
                flag = true;
                break;
            }
        }
        return !flag;
    }
}