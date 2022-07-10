package com.sigabem.calculadoradefrete.service;

import com.sigabem.calculadoradefrete.model.Pacote;
import com.sigabem.calculadoradefrete.service.dto.PacoteVO;

public interface FreteService {

    Pacote calcularFrete(Integer id) throws Exception;

    Integer salvar(PacoteVO pacote);
}
