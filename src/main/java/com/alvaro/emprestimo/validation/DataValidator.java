package com.alvaro.emprestimo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataValidator implements ConstraintValidator<DataValid, String> {
    @Override
    public void initialize(DataValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var data = LocalDateTime.now();

        try {
            data = LocalDateTime.parse(s, formatoData);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
