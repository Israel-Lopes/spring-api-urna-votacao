package com.urna.app.service;

import com.urna.app.percistence.entity.SessaoEntity;
import com.urna.app.repository.VotacaoRepository;
import com.urna.app.service.interfaces.VotacaoInterface;
import com.urna.app.service.model.Sessao;
import com.urna.app.web.mapper.SessaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class IVotacaoService implements VotacaoInterface {
    @Autowired(required = true)
    VotacaoRepository repository;
    @Override
    public ResponseEntity createVoto(Long id, Sessao model) {
        try {
            SessaoEntity entity = repository.save(SessaoMapper.marshall(model));
            return entity != null
                    ? ResponseEntity.ok().header("Content-Type", "application/json")
                        .body(SessaoMapper.unmarshall(entity))
                    : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
