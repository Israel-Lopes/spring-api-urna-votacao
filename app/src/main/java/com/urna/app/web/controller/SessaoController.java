package com.urna.app.web.controller;

import com.urna.app.service.SessaoService;
import com.urna.app.service.model.Sessao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/product")
@RestController
public class SessaoController {

    @Autowired(required=true)
    private SessaoService service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity getProduct(HttpServletRequest request, @PathVariable Long id) throws Exception {
        return service.getProduct(request, id);
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<Sessao>> getProductList(HttpServletRequest request) throws Exception {
        return service.getProductList(request);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity createProduct(@RequestBody Sessao model) throws Exception {
        return service.createProduct(model);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity updateProduct(@RequestBody Sessao model) throws Exception {
        return service.updateProduct(model);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity deleteProduct(@PathVariable Long id) throws Exception {
        return service.deleteProduct(id);
    }
}
