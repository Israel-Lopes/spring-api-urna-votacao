package com.urna.app.web.controller;

import com.urna.app.service.IPautaService;
import com.urna.app.service.ISessaoService;
import com.urna.app.service.model.Pauta;
import com.urna.app.service.model.Sessao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/sessao")
public class SessaoController {
    @Autowired(required=true)
    private ISessaoService service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity getSessao(HttpServletRequest request, @PathVariable Long id) throws Exception {
        return service.getSessao(request, id);
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<Sessao>> getSessaoList(HttpServletRequest request) throws Exception {
        return service.getSessaoList(request);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity createSessao(@RequestBody Sessao model) throws Exception {
        return service.createSessao(model);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity updateSessao(@RequestBody Sessao model) throws Exception {
        return service.updateSessao(model);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity deleteSessao(@PathVariable Long id) throws Exception {
        return service.deleteSessao(id);
    }
}
