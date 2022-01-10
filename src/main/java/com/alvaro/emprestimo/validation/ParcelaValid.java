package com.alvaro.emprestimo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ParcelaValidator.class)

public @interface ParcelaValid {

    String message() default "A data da primeira parcela deve ser no máximo 3 meses após o dia atual";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}