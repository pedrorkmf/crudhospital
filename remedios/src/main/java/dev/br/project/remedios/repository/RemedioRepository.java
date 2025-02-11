package dev.br.project.remedios.repository;

import dev.br.project.remedios.dtos.DadosListagemRemedioDTO;
import dev.br.project.remedios.model.Remedio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemedioRepository extends JpaRepository <Remedio,Long> {

    List<Remedio> findAllByAtivoTrue();

}
