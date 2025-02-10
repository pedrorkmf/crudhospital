package dev.br.project.remedios.model;

import dev.br.project.remedios.dtos.DadosAtualizarRemedioDTO;
import dev.br.project.remedios.dtos.DadosCadastrosRemedioDTO;
import dev.br.project.remedios.enums.Laboratorio;
import dev.br.project.remedios.enums.Via;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import java.time.LocalDate;

@Entity(name = "remedios")
@Table(name = "Remedio")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Remedio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String nome;
    private String lote;
    private int quantidade;
    private LocalDate validade;

    @Enumerated(EnumType.STRING)
    private Laboratorio laboratorio;
    @Enumerated(EnumType.STRING)
    private Via via;

    public Remedio(DadosCadastrosRemedioDTO dados){
        this.nome = dados.nome();
        this.quantidade = dados.quantidade();
        this.validade = dados.validade();
        this.lote = dados.lote();
        this.via = dados.via();
        this.laboratorio = dados.laboratorio();
    }

    public void atualizarInformacoes(@Valid DadosAtualizarRemedioDTO dados){
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.via() != null){
            this.via = dados.via();
        }
        if(dados.laboratorio() != null){
            this.laboratorio = dados.laboratorio();
        }
    }

}
