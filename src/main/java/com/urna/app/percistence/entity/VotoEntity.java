package com.urna.app.percistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "voto")
public class VotoEntity {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "associado_id")
    private AssociadoEntity associado;

    @OneToOne
    @JoinColumn(name = "pauta_id")
    private PautaEntity pauta;

    @Column(name = "voto", nullable = false)
    private Boolean voto;

    @ManyToMany(mappedBy = "votos")
    private Set<SessaoEntity> sessoes = new HashSet<>();
}
