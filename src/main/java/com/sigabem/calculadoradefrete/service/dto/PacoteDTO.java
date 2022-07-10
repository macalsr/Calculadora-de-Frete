package com.sigabem.calculadoradefrete.service.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class PacoteDTO {

    private Integer id;

    private Integer peso;

    private String cepOrigem;

    private String cepDestino;

    private String nomeDestinatario;
}
