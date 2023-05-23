package com.urna.app.web.controller;

import com.urna.app.service.PautaService;
import com.urna.app.service.SessaoService;
import com.urna.app.service.model.Pauta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/login")
@RestController
public class PautaController {
    public static final Logger log = LoggerFactory.getLogger(SessaoService.class);
    @Autowired(required=true)
    private PautaService service;
    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity login(@RequestBody Pauta model) throws Exception {
        return service.loginUser(model);
    }
}
