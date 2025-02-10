package dev.br.project.remedios.dtos;

import dev.br.project.remedios.enums.Laboratorio;
import dev.br.project.remedios.enums.Via;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastrosRemedioDTO(

        @NotBlank //uma String ela vem vazia,e não permite o usario enviar o nome vazio
        String nome,
        @Enumerated// e uma enum
        Via via,
        @NotBlank
        String lote,

        int quantidade,

        @Future //Para por a validade ou seja,por uma validade a partir de hoje ate o futuro.
        LocalDate validade,
        @Enumerated
        Laboratorio laboratorio) {


}
