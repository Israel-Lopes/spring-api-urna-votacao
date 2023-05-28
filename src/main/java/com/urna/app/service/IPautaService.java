package com.urna.app.service;

import com.urna.app.service.interfaces.PautaInterface;
import com.urna.app.service.model.Pauta;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class IPautaService implements PautaInterface {

    @Override
    public ResponseEntity getPauta(HttpServletRequest request, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<Pauta>> getPautaList(HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity createPauta(Pauta model) {
        return null;
    }

    @Override
    public ResponseEntity updatePauta(Pauta model) {
        return null;
    }

    @Override
    public ResponseEntity deletePauta(Long id) {
        return null;
    }
}
