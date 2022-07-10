package com.sigabem.calculadoradefrete.web.rest;

import com.sigabem.calculadoradefrete.model.Pacote;
import com.sigabem.calculadoradefrete.service.FreteService;
import com.sigabem.calculadoradefrete.service.dto.PacoteVO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/frete")
public class FreteController {

    private final FreteService freteService;

    public FreteController(FreteService freteService) {
        this.freteService = freteService;
    }

    @RequestMapping(value = "/salvarPacote", method = RequestMethod.POST)
    public ResponseEntity<Integer> save(PacoteVO pacote) {
        return ResponseEntity.ok(freteService.salvar(pacote));
    }
    @RequestMapping(value = "/calcularFrete", method = RequestMethod.POST)
    public ResponseEntity<Pacote> save(Integer id) throws Exception {
        return ResponseEntity.ok(freteService.calcularFrete(id));
    }

}
