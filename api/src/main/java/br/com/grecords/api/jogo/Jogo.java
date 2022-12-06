package br.com.grecords.api.jogo;


import jakarta.persistence.*;
import lombok.*;


@Entity(name = "jogos")
@Table(name = "jogos")
//Lombok Setting
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private String ano;
    @Enumerated
    private Plataforma plataforma;
    private String faixaEtaria;
    private Byte quantidade;
    private boolean ativo;

    public Jogo(DadosCadastroJogo dados) {
        this.ativo = true;
        this.titulo = dados.titulo();
        this.ano = dados.ano();
        this.plataforma = dados.plataforma();
        this.faixaEtaria = dados.faixaEtaria();
        this.quantidade = dados.quantidade();
    }

    public void atualizarInformacoes(DadosEdicaoJogo dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.ano() != null) {
            this.ano = dados.ano();
        }
        if (dados.plataforma() != null) {
            this.plataforma = dados.plataforma();
        }
        if (dados.faixaEtaria() != null) {
            this.faixaEtaria = dados.faixaEtaria();
        }
        if (dados.quantidade() != null) {
            this.quantidade = dados.quantidade();
        }
    }

    public void deletarLogico() {
        this.ativo = false;
    }

    public void reduzirQuantidade() {
        if (this.quantidade > 0) {
            this.quantidade = (byte) (this.quantidade - 1);
        }
    }
}
