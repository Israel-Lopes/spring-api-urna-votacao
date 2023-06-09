package com.urna.app.service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.urna.app.percistence.entity.PautaEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class FormularioDeVoto {
    private Long id;
    private List<Boolean> votos;
    private List<Long> idAssociadosQueVotaram;
}
