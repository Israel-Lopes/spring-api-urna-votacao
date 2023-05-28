package com.urna.app.service.interfaces;

import com.urna.app.service.model.Pauta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface PautaInterface {
    public ResponseEntity getPauta(HttpServletRequest request, Long id);
    public ResponseEntity<List<Pauta>> getPautaList(HttpServletRequest request);
    public ResponseEntity createPauta(@RequestBody Pauta model);
    public ResponseEntity updatePauta(@RequestBody Pauta model);
    public ResponseEntity deletePauta(@PathVariable Long id);
}
