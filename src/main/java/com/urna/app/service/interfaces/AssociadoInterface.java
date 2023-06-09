package com.urna.app.service.interfaces;

import com.urna.app.service.model.Associado;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AssociadoInterface {
    public ResponseEntity getAssociado(HttpServletRequest request, Long id);
    public ResponseEntity<List<Associado>> getAssociadoList(HttpServletRequest request);
    public ResponseEntity createAssociado(@RequestBody Associado model);
    public ResponseEntity updateAssociado(@RequestBody Associado model);
    public ResponseEntity deleteAssociado(@PathVariable Long id);
}
