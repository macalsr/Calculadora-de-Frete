package com.sigabem.calculadoradefrete.converter;

import com.sigabem.calculadoradefrete.model.Pacote;
import com.sigabem.calculadoradefrete.service.dto.PacoteDTO;
import org.springframework.stereotype.Component;

@Component
public class PacoteDTOConverter implements Converter<Pacote, PacoteDTO> {


    @Override
    public Pacote converter(PacoteDTO clss) {
        return Pacote.builder()
                .id(clss.getId())
                .cepDestino(clss.getCepDestino())
                .cepOrigem(clss.getCepOrigem())
                .nomeDestinatario(clss.getNomeDestinatario())
                .peso(clss.getPeso())
                .build();
    }
}
