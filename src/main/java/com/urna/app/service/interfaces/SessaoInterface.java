package com.urna.app.service.interfaces;

import com.urna.app.service.model.Sessao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface SessaoInterface {
    public ResponseEntity getSessao(HttpServletRequest request, Long id);
    public ResponseEntity<List<Sessao>> getSessaoList(HttpServletRequest request);
    public ResponseEntity createSessao(@RequestBody Sessao model);
    public ResponseEntity updateSessao(@RequestBody Sessao model);
    public ResponseEntity deleteSessao(@PathVariable Long id);
}
