package br.com.grecords.api.jogo;

import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DadosCadastroJogo(
        @NotBlank(message = "O campo titulo não pode ser vazio")
        String titulo,
        @NotBlank(message = "O campo ano não pode ser vazio")
        String ano,
        @NotNull(message = "O campo plataforma não pode ser vazio")
        Plataforma plataforma,
        @NotBlank(message = "O campo faixaEtaria não pode ser vazio")
        String faixaEtaria,
        @NotNull(message = "O campo quantidade não pode ser nulo") @Positive(message = "A quantidade deve ser maior que 0")
        Byte quantidade
) {
}
