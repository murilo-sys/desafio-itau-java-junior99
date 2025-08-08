package com.github.murilo_sys.desafio_itau_java_junior.util;

import org.apache.coyote.BadRequestException;

public class NumberVerify {

    public static void isValid(Double valor) {
        if (valor <= 0) throw new IllegalArgumentException();{}
    }

}
