package com.urna.app.service;

import com.urna.app.service.interfaces.AssociadoInterface;
import com.urna.app.service.model.Associado;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class IAssociadoService implements AssociadoInterface {

    @Override
    public ResponseEntity getAssociado(HttpServletRequest request, Long id) {
        return null;
    }
    @Override
    public ResponseEntity<List<Associado>> getAssociadoList(HttpServletRequest request) {
        return null;
    }
    @Override
    public ResponseEntity createAssociado(@RequestBody Associado model) {
        return null;
    }
    @Override
    public ResponseEntity updateAssociado(Associado model) {
        return null;
    }

    @Override
    public ResponseEntity deleteAssociado(Long id) {
        return null;
    }
}
