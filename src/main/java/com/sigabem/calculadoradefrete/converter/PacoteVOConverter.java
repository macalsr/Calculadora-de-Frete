package com.sigabem.calculadoradefrete.converter;

import com.sigabem.calculadoradefrete.service.dto.PacoteDTO;
import com.sigabem.calculadoradefrete.service.dto.PacoteVO;
import org.springframework.stereotype.Component;

@Component
public class PacoteVOConverter implements Converter<PacoteDTO, PacoteVO> {


    @Override
    public PacoteDTO converter(PacoteVO clss) {
        return PacoteDTO.builder()
                .cepDestino(clss.getCepDestino())
                .cepOrigem(clss.getCepOrigem())
                .nomeDestinatario(clss.getNomeDestinatario())
                .peso(clss.getPeso())
                .build();
    }
}
