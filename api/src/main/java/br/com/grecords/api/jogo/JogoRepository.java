package br.com.grecords.api.jogo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoRepository extends JpaRepository<Jogo, Long> {
    Page<Jogo> findAllByAtivoTrue(Pageable paginacao);

    Jogo getReferenceByIdAndAtivoTrue(Long id);

    Jogo findByIdAndAtivoTrue(Long id);
}
