package br.com.grecords.api.jogo;

import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DadosCadastroJogo(
        @NotBlank
        String titulo,
        @NotBlank
        String ano,
        @NotNull
        Plataforma plataforma,
        @NotBlank
        String faixaEtaria,
        @NotNull(message = "O campo quantidade não pode ser nulo") @Positive(message = "A quantidade deve ser maior que 0")
        Byte quantidade
) {
}
