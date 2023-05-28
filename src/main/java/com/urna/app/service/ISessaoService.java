package com.urna.app.service;

import com.urna.app.service.interfaces.SessaoInterface;
import com.urna.app.service.model.Sessao;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class ISessaoService implements SessaoInterface {

    @Override
    public ResponseEntity getSessao(HttpServletRequest request, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<Sessao>> getSessaoList(HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity createSessao(Sessao model) {
        return null;
    }

    @Override
    public ResponseEntity updateSessao(Sessao model) {
        return null;
    }

    @Override
    public ResponseEntity deleteSessao(Long id) {
        return null;
    }
}
