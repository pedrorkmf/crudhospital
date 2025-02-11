package dev.br.project.remedios.controller;

import dev.br.project.remedios.dtos.DadosAtualizarRemedioDTO;
import dev.br.project.remedios.dtos.DadosCadastrosRemedioDTO;
import dev.br.project.remedios.dtos.DadosDetalhamentoRemedioDTO;
import dev.br.project.remedios.dtos.DadosListagemRemedioDTO;
import dev.br.project.remedios.model.Remedio;
import dev.br.project.remedios.repository.RemedioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;

@RestController
@RequestMapping("/remedios")
public class RemedioController {

    @Autowired
    private RemedioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoRemedioDTO> cadastrar(@RequestBody @Valid DadosCadastrosRemedioDTO dados, UriComponentsBuilder uriBuilder){
        var remedio = new Remedio(dados);
        repository.save(remedio);
        var uri = uriBuilder.path("/remedios/{id}").buildAndExpand(remedio.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoRemedioDTO(remedio));

    }

    @GetMapping
    public ResponseEntity<List<DadosListagemRemedioDTO>> listar(){
        var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemRemedioDTO::new).toList();
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhamentoRemedioDTO> atualizar(@RequestBody @Valid DadosAtualizarRemedioDTO dados){
    var remedio = repository.getReferenceById(dados.id());
    remedio.atualizarInformacoes(dados);

    return ResponseEntity.ok(new DadosDetalhamentoRemedioDTO(remedio));
    }
    
    @PutMapping("ativar/{id}")
    @Transactional
    public ResponseEntity<Void> ativar(@PathVariable Long id){
        var remedio = repository.getReferenceById(id);
        remedio.ativar();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> Excluir(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativar(@PathVariable Long id){
        var remedio = repository.getReferenceById(id);
        remedio.inativar();
        return ResponseEntity.noContent().build();
    }


}
