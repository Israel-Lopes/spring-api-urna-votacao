package com.urna.app.percistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Data
@Builder
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sessao")
public class SessaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "tempo_da_votacao", columnDefinition = "TIME DEFAULT '00:01:00'")
    private LocalTime tempoDaVotacao;

    @Column(name = "votacao_em_andamento")
    private Boolean votacaoEmAndamento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "formulario_id")
    private FormularioDeVotoEntity formulario;
}