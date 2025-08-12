package com.github.murilo_sys.desafio_itau_java_junior.model;

import org.jetbrains.annotations.NotNull;

import java.time.OffsetDateTime;

public record Transacao(
        @NotNull("Valor é obrigatório") Double valor,
        @NotNull("Data é obrigatória") OffsetDateTime dataHora)
{
}
