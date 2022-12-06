package br.com.grecords.api.jogo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DadosEdicaoJogo(
        @NotNull(message = "Um id de jogo deve ser fornecido")
        Long id,
        String titulo,
        String ano,
        Plataforma plataforma,
        String faixaEtaria,
        @Positive
        Byte quantidade
) {

}
