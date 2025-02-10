package dev.br.project.remedios.controller;

import dev.br.project.remedios.dtos.DadosAtualizarRemedioDTO;
import dev.br.project.remedios.dtos.DadosCadastrosRemedioDTO;
import dev.br.project.remedios.dtos.DadosListagemRemedioDTO;
import dev.br.project.remedios.model.Remedio;
import dev.br.project.remedios.repository.RemedioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/remedios")
public class RemedioController {

    @Autowired
    private RemedioRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastrosRemedioDTO dados){
        repository.save(new Remedio(dados));
    }

    @GetMapping
    public List<DadosListagemRemedioDTO> listar(){
        return repository.findAll().stream().map(DadosListagemRemedioDTO::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarRemedioDTO dados){
    var remedio = repository.getReferenceById(dados.id());
    remedio.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void Excluir(@PathVariable Long id){
        repository.deleteById(id);
    }
}
