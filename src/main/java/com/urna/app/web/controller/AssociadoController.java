package com.urna.app.web.controller;

import com.urna.app.service.IAssociadoService;
import com.urna.app.service.model.Associado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/associado")
public class AssociadoController {
    @Autowired(required=true)
    private IAssociadoService service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity getAssociado(HttpServletRequest request, @PathVariable Long id) throws Exception {
        return service.getAssociado(request, id);
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<Associado>> getAssociadoList(HttpServletRequest request) throws Exception {
        return service.getAssociadoList(request);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity createAssociado(@RequestBody Associado model) throws Exception {
        return service.createAssociado(model);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity updateAssociado(@RequestBody Associado model) throws Exception {
        return service.updateAssociado(model);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity deleteAssociado(@PathVariable Long id) throws Exception {
        return service.deleteAssociado(id);
    }
}
