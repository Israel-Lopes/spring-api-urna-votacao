package com.urna.app.service;

import com.urna.app.percistence.entity.AssociadoEntity;
import com.urna.app.repository.AssociadoRepository;
import com.urna.app.service.interfaces.AssociadoInterface;
import com.urna.app.service.model.Associado;
import com.urna.app.web.mapper.AssociadoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IAssociadoService implements AssociadoInterface {

    @Autowired(required = true)
    AssociadoRepository associadoRepository;

    @Override
    public ResponseEntity getAssociado(HttpServletRequest request, Long id) {
        try {
            Optional<AssociadoEntity> entity = associadoRepository.findById(id);
            return entity.isPresent()
                    ? ResponseEntity.ok().header("Content-Type", "application/json")
                        .body(AssociadoMapper.unmarshall(entity.get()))
                    : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @Override
    public ResponseEntity<List<Associado>> getAssociadoList(HttpServletRequest request) {
        try {
            List<AssociadoEntity> entities = associadoRepository.findAll();
            List<Associado> associados = new ArrayList<>(AssociadoMapper.unmarshall(entities.stream().toList()));

            return associados != null
                    ? ResponseEntity.ok().header("Content-Type", "application/json").body(associados)
                    : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity createAssociado(@RequestBody Associado model) {
        try {
            AssociadoEntity entity = associadoRepository.save(AssociadoMapper.marshall(model));
            return entity != null
                    ? ResponseEntity.ok().header("Content-Type", "application/json")
                        .body(AssociadoMapper.unmarshall(entity))
                    : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @Override
    public ResponseEntity updateAssociado(Associado model) {
        try {
            Optional<AssociadoEntity> optionalEntity = associadoRepository.findById(model.getId());

            if (optionalEntity.isPresent()) {
                AssociadoEntity entity = optionalEntity.get();
                entity.setCpf(model.getCpf());
                associadoRepository.save(entity);
                return ResponseEntity.ok()
                        .header("Content-Type", "application/json")
                        .body(AssociadoMapper.unmarshall(entity));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity deleteAssociado(Long id) {
        try {
            return associadoRepository.findById(id).map(record -> {
                associadoRepository.deleteById(id);
                return ResponseEntity.ok().header("Content-Type", "application/json").body(id);
            }).orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
