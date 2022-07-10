package com.sigabem.calculadoradefrete.service.impl;

import com.sigabem.calculadoradefrete.converter.PacoteDTOConverter;
import com.sigabem.calculadoradefrete.converter.PacoteVOConverter;
import com.sigabem.calculadoradefrete.model.Pacote;
import com.sigabem.calculadoradefrete.repository.PacoteRepository;
import com.sigabem.calculadoradefrete.service.FreteService;
import com.sigabem.calculadoradefrete.service.dto.PacoteDTO;
import com.sigabem.calculadoradefrete.service.dto.PacoteVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

@Service
@Slf4j
@Transactional
public class FreteServiceImpl implements FreteService {

    final CepService cepService;
    private final PacoteRepository pacoteRepository;
    final PacoteDTOConverter pacoteDTOConverter;
    final PacoteVOConverter converter;
    public FreteServiceImpl(PacoteRepository pacoteRepository, CepService cepService, PacoteVOConverter converter, PacoteDTOConverter pacoteDTOConverter) {
        this.pacoteRepository = pacoteRepository;
        this.cepService = cepService;
        this.converter = converter;
        this.pacoteDTOConverter = pacoteDTOConverter;
    }

    @Override
    public Pacote calcularFrete(Integer id) {
        try {
        Optional<Pacote> pacoteOptional = pacoteRepository.findById(id);
        if(pacoteOptional.isPresent()) {
            Pacote pacote = pacoteOptional.get();
            Double desconto = calcularDesconto(pacote);
            Double valorFrete = valorFrete(pacote, desconto);
            pacote.setVlTotalFrete(valorFrete);
            pacote.setDataPrevistaEntrega(calcularDataPrevistaEntrega(pacote));
            pacote.setDataConsulta(date(new Date()));
            return pacote;
        }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    @Override
    public Integer salvar(PacoteVO pacoteVO) {
        try {
        PacoteDTO pacoteDTO = converter.converter(pacoteVO);
        Pacote pacote = pacoteDTOConverter.converter(pacoteDTO);
        pacoteRepository.save(pacote);
        return pacote.getId();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String calcularDataPrevistaEntrega(Pacote pacote) throws Exception {
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        Date date = new Date();
        if (dddsIguais(pacote)) {
            c.add(Calendar.DATE, 1);
            date = c.getTime();
        }
        if (estadosIguais(pacote) && !dddsIguais(pacote))  {
            c.add(Calendar.DATE, 3);
            date = c.getTime();
        }
        if (!estadosIguais(pacote) && !dddsIguais(pacote)) {
            c.add(Calendar.DATE, 10);
            date = c.getTime();
        }
        return date(date);
    }

    private String date(Date date) throws ParseException {
        Locale locale = new Locale("pt", "BR");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
        return dateFormat.format(date);
    }

    private Double calcularDesconto(Pacote pacote) throws Exception {
        double desconto = 0;
        if (dddsIguais(pacote)) {
            desconto = 0.50;
        }
        if (estadosIguais(pacote)) {
            desconto = 0.75;

        }
        if (!estadosIguais(pacote)) {
            desconto = 0.0;

        }
        return desconto;
    }

    private Double valorFrete(Pacote pacote, Double desconto) {
        return pacote.getPeso() * desconto;
    }

    private boolean estadosIguais(Pacote pacote) throws Exception {
        String ufOrigem = cepService.buscaEnderecoPelo(pacote.getCepDestino()).getUf();
        String ufDestino = cepService.buscaEnderecoPelo(pacote.getCepDestino()).getUf();
        return ufDestino.equals(ufOrigem);
    }

    private boolean dddsIguais(Pacote pacote) throws Exception {
        String dddOrigem = cepService.buscaEnderecoPelo(pacote.getCepOrigem()).getDdd();
        String dddDestino = cepService.buscaEnderecoPelo(pacote.getCepDestino()).getDdd();
        return dddOrigem.equals(dddDestino);
    }

}
