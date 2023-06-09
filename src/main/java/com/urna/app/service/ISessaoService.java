package com.urna.app.service;

import com.urna.app.percistence.entity.SessaoEntity;
import com.urna.app.repository.SessaoRepository;
import com.urna.app.service.interfaces.SessaoInterface;
import com.urna.app.service.model.Sessao;
import com.urna.app.web.mapper.SessaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ISessaoService implements SessaoInterface {

    @Autowired(required = true)
    SessaoRepository repository;

    @Override
    public ResponseEntity getSessao(HttpServletRequest request, Long id) {
        try {
            Optional<SessaoEntity> entity = repository.findById(id);
            return entity.isPresent()
                    ? ResponseEntity.ok().header("Content-Type", "application/json")
                    .body(SessaoMapper.unmarshall(entity.get()))
                    : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @Override
    public ResponseEntity<List<Sessao>> getSessaoList(HttpServletRequest request) {
        try {
            List<SessaoEntity> entities = repository.findAll();
            List<Sessao> sessoes = new ArrayList<>(SessaoMapper.unmarshall(entities.stream().toList()));
            return sessoes != null
                    ? ResponseEntity.ok().header("Content-Type", "application/json").body(sessoes)
                    : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @Override
    public ResponseEntity createSessao(Sessao model) {
        try {
            model.setVotacaoEmAndamento(false);
            SessaoEntity entity = repository.save(SessaoMapper.marshall(model));
            return entity != null
                    ? ResponseEntity.ok().header("Content-Type", "application/json")
                        .body(SessaoMapper.unmarshall(entity))
                    : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @Override
    public ResponseEntity patchAtivaSessao(Long id, Sessao model) {
        try {
            Optional<SessaoEntity> optionalEntity = repository.findById(id);
            SessaoEntity entity = optionalEntity.get();

            if (optionalEntity.isPresent() && entity.getVotacaoEmAndamento() == false) {
                entity.setVotacaoEmAndamento(true);

                LocalTime tempoDaVotacao = entity.getTempoDaVotacao();
                LocalDateTime dataHoraAtual = LocalDateTime.now();

                LocalDateTime inicioDaContagem = dataHoraAtual;
                LocalDateTime fimDaContagem = dataHoraAtual.plusMinutes(tempoDaVotacao.getMinute())
                        .plusHours(tempoDaVotacao.getHour());

                entity.setInicioDaContagem(inicioDaContagem);
                entity.setFimDaContagem(fimDaContagem);

                repository.save(entity);
                return ResponseEntity.ok()
                        .header("Content-Type", "application/json")
                        .body(SessaoMapper.unmarshall(entity));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
