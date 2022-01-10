package com.alvaro.emprestimo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ParcelaValidator implements ConstraintValidator<ParcelaValid, String> {

    @Override
    public void initialize(ParcelaValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var dataLimite = LocalDateTime.now().plusMonths(3);
        var dataUSer = LocalDateTime.now();
        var dataAtual = LocalDateTime.now();

        try {
            dataUSer = LocalDateTime.parse(s, formatoData);
        } catch (Exception e) {
            return false;
        }

        if (dataUSer.isAfter(dataLimite))
            return false;

        if (dataUSer.isBefore(dataAtual))
            return false;

        return true;
    }
}
