package com.urna.app.service;

import com.urna.app.service.interfaces.FormularioDeVotoInterface;
import com.urna.app.service.model.FormularioDeVoto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class IFormularioDeVotoService implements FormularioDeVotoInterface {
    @Override
    public ResponseEntity getFormularioDeVoto(HttpServletRequest request, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<FormularioDeVoto>> getFormularioDeVotoList(HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity createFormularioDeVoto(FormularioDeVoto model) {
        return null;
    }

    @Override
    public ResponseEntity updateFormularioDeVoto(FormularioDeVoto model) {
        return null;
    }

    @Override
    public ResponseEntity deleteFormularioDeVoto(Long id) {
        return null;
    }
}
