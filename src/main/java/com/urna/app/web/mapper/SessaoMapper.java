package com.urna.app.web.mapper;

import com.urna.app.percistence.entity.AssociadoEntity;
import com.urna.app.percistence.entity.SessaoEntity;
import com.urna.app.service.model.Associado;
import com.urna.app.service.model.Sessao;

import java.util.Collection;
import java.util.stream.Collectors;

public class SessaoMapper {
    private SessaoMapper() { super(); }
    public static Collection<SessaoEntity> marshall(Collection<Sessao> models){
        return models.stream().map(SessaoMapper::marshall).collect(Collectors.toList());
    }
    public static Collection<Sessao> unmarshall(Collection<SessaoEntity> entitys){
        return entitys.stream().map(SessaoMapper::unmarshall).collect(Collectors.toList());
    }
    public static SessaoEntity marshall(Sessao model) {
        return SessaoEntity.builder()
                .id(model.getId())
                .tempoDaVotacao(model.getTempoDaVotacao())
                .votacaoEmAndamento(model.getVotacaoEmAndamento())
                .formulario(model.getFormulario())
                .build();
    }
    public static Sessao unmarshall(SessaoEntity entity) {
        return Sessao.builder()
                .id(entity.getId())
                .tempoDaVotacao(entity.getTempoDaVotacao())
                .votacaoEmAndamento(entity.getVotacaoEmAndamento())
                .formulario(entity.getFormulario())
                .build();
    }
}
