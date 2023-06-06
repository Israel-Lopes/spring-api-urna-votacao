package com.urna.app.service.interfaces;

import com.urna.app.service.model.VotoAssociado;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface VotacaoInterface {
    public ResponseEntity createVoto(String cpf, @RequestBody VotoAssociado model);
}
