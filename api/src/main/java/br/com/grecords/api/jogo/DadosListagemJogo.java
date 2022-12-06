package br.com.grecords.api.jogo;

public record DadosListagemJogo(
        long id,
        String titulo,
        String ano,
        Plataforma plataforma,
        String faixaEtaria,
        Byte quantidade,
        boolean ativo) {

    public DadosListagemJogo(Jogo jogo) {
            this(jogo.getId(), jogo.getTitulo(), jogo.getAno(), jogo.getPlataforma(), jogo.getFaixaEtaria(),
                    jogo.getQuantidade(), jogo.isAtivo());
    }

}
