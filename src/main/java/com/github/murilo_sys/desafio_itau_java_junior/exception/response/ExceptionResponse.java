package com.github.murilo_sys.desafio_itau_java_junior.exception.response;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String errorCode, String errorMessage, String details) {
}
