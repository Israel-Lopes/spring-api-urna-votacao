package com.urna.app.web.controller;

import com.urna.app.service.ISessaoService;
import com.urna.app.service.model.Sessao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/votacao")
public class VotacaoController {
    @Autowired(required=true)
    private ISessaoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity createVotacao(Long id, @RequestBody Sessao model) throws Exception {
        return service.createSessao(model);
    }
}
