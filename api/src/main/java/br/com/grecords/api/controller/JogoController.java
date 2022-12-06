package br.com.grecords.api.controller;

import br.com.grecords.api.jogo.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jogos")
public class JogoController {

    @Autowired
    private JogoRepository repository;

    @PostMapping
    @Transactional
    public void adicionar(@RequestBody @Valid DadosCadastroJogo dados) {
        repository.save(new Jogo(dados));
    }

    @GetMapping
    public Page<DadosListagemJogo> listar(@PageableDefault(size=10, sort={"titulo"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemJogo ::new);
    }

    @GetMapping("/{id}")
    public DadosListagemJogo listarJogoPorId(@PathVariable Long id) {
            Jogo jogo = repository.findByIdAndAtivoTrue(id);
            return new DadosListagemJogo(jogo);
    }

    @PutMapping
    @Transactional
    public void editar(@RequestBody DadosEdicaoJogo dados) {
        Jogo jogo = repository.getReferenceByIdAndAtivoTrue(dados.id());
        jogo.atualizarInformacoes(dados);
    }

    @PutMapping("/{id}/reduzirqtd")
    @Transactional
    public void reduzirQuantidade(@PathVariable Long id) {
        Jogo jogo = repository.getReferenceByIdAndAtivoTrue(id);
        jogo.reduzirQuantidade();
    }



    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id) {
        Jogo jogo = repository.getReferenceById(id);
        jogo.deletarLogico();
    }
}
