package com.urna.app.web.controller;

import com.urna.app.service.IAssociadoService;
import com.urna.app.service.IFormularioDeVotoService;
import com.urna.app.service.model.Associado;
import com.urna.app.service.model.FormularioDeVoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/formulario_devoto")
public class FormularioDeVotoController {
    @Autowired(required=true)
    private IFormularioDeVotoService service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity getFormularioDeVoto(HttpServletRequest request, @PathVariable Long id) throws Exception {
        return service.getFormularioDeVoto(request, id);
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<FormularioDeVoto>> getFormularioDeVotoList(HttpServletRequest request) throws Exception {
        return service.getFormularioDeVotoList(request);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity createFormularioDeVoto(@RequestBody FormularioDeVoto model) throws Exception {
        return service.createFormularioDeVoto(model);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity updateFormularioDeVoto(@RequestBody FormularioDeVoto model) throws Exception {
        return service.updateFormularioDeVoto(model);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity deleteFormularioDeVoto(@PathVariable Long id) throws Exception {
        return service.deleteFormularioDeVoto(id);
    }
}
