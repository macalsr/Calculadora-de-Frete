package com.sigabem.calculadoradefrete.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pacote")
public class Pacote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "peso", nullable = false)
    private Integer peso;

    @Column(name = "cep_origem", nullable = false)
    private String cepOrigem;

    @Column(name = "cep_destino", nullable = false)
    private String cepDestino;

    @Column(name = "nome_destinatario", nullable = false)
    private String nomeDestinatario;

    @Column(name = "vl_total_frete")
    private Double vlTotalFrete;

    @Column(name = "data_prevista_entrega")
    private String dataPrevistaEntrega;

    @Column(name = "data_consulta")
    private String dataConsulta;
}
