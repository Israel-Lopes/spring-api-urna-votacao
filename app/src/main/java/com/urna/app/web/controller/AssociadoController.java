package com.urna.app.web.controller;

import com.urna.app.service.AssociadoService;
import com.urna.app.service.model.Associado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/cart")
@RestController
public class AssociadoController {
    @Autowired(required=true)
    private AssociadoService service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity getCart(HttpServletRequest request, @PathVariable Long id) throws Exception {
        return service.getCart(request, id);
    }
    @GetMapping("/token")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity getCartByToken(HttpServletRequest request) throws Exception {
        return service.getCartByToken(request);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity createCart(HttpServletRequest request, @RequestBody Associado model) throws Exception {
        return service.createCart(request, model);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity updateCart(HttpServletRequest request, @RequestBody Associado model) throws Exception {
        return service.updateCart(request, model);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity deleteCart(HttpServletRequest request, @PathVariable Long id) throws Exception {
        return service.deleteCart(request, id);
    }
}
