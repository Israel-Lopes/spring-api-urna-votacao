package com.urna.app.percistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

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

    @ManyToMany
    @JoinTable(
            name = "sessao_votos",
            joinColumns = @JoinColumn(name = "sessao_id"),
            inverseJoinColumns = @JoinColumn(name = "voto_id")
    )
    @OrderColumn(name = "voto_order")
    private List<VotoEntity> votos;
}