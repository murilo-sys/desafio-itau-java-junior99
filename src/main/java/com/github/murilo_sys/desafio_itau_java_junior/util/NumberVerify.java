package com.github.murilo_sys.desafio_itau_java_junior.util;
import com.github.murilo_sys.desafio_itau_java_junior.exception.BadRequestException;

public class NumberVerify {

    public static void isValid(Double valor) {
        if (valor == null || valor <= 0) throw new BadRequestException("Valor deve ser maior que zero");
    }

}
