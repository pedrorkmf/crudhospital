package dev.br.project.remedios.dtos;

import dev.br.project.remedios.enums.Laboratorio;
import dev.br.project.remedios.enums.Via;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarRemedioDTO(
        @NotNull
        Long id,
        String nome,
        Via via,
        Laboratorio laboratorio) {
}
