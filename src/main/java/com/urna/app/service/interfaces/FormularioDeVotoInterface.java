package com.urna.app.service.interfaces;

import com.urna.app.service.model.Associado;
import com.urna.app.service.model.FormularioDeVoto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface FormularioDeVotoInterface {
    public ResponseEntity getFormularioDeVoto(HttpServletRequest request, Long id);
    public ResponseEntity<List<FormularioDeVoto>> getFormularioDeVotoList(HttpServletRequest request);
    public ResponseEntity createFormularioDeVoto(@RequestBody FormularioDeVoto model);
    public ResponseEntity updateFormularioDeVoto(@RequestBody FormularioDeVoto model);
    public ResponseEntity deleteFormularioDeVoto(@PathVariable Long id);
}
