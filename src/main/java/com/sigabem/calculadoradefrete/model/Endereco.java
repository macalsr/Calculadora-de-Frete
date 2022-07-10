package com.sigabem.calculadoradefrete.model;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Endereco {

    String logradouro;
    String bairro;
    String localidade;
    String ddd;
    String uf;

}
