package dev.br.project.remedios.dtos;

import dev.br.project.remedios.enums.Laboratorio;
import dev.br.project.remedios.enums.Via;
import dev.br.project.remedios.model.Remedio;

import java.time.LocalDate;

public record DadosDetalhamentoRemedioDTO(
        Long id,
        String nome,
        Via via,
        String lote,
        int quantidade,
        LocalDate validade,
        Laboratorio laboratorio,
        Boolean ativo
) {

    public DadosDetalhamentoRemedioDTO(Remedio remedio){
        this(
                remedio.getId(),
                remedio.getNome(),
                remedio.getVia(),
                remedio.getLote(),
                remedio.getQuantidade(),
                remedio.getValidade(),
                remedio.getLaboratorio(),
                remedio.getAtivo()
        );
    }

}
