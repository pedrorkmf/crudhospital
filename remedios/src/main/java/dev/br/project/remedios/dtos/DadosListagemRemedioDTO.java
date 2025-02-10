package dev.br.project.remedios.dtos;


import dev.br.project.remedios.enums.Laboratorio;
import dev.br.project.remedios.enums.Via;
import dev.br.project.remedios.model.Remedio;

import java.time.LocalDate;

public record DadosListagemRemedioDTO(Long id,String nome, Via via, String lote, Laboratorio laboratorio, LocalDate validade) {

    public DadosListagemRemedioDTO(Remedio remedio){
        this(remedio.getId(),remedio.getNome(),remedio.getVia(),remedio.getLote(),remedio.getLaboratorio(),remedio.getValidade());
    }
}
