package com.urna.app.service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.urna.app.percistence.entity.FormularioDeVotoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.Duration;
import java.time.LocalTime;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class Sessao {
    private Long id;
    private LocalTime tempoDaVotacao;
    private Boolean votacaoEmAndamento;
    private FormularioDeVotoEntity formulario;
}
