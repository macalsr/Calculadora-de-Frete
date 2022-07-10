package com.sigabem.calculadoradefrete.service.impl;

import com.google.gson.Gson;
import com.sigabem.calculadoradefrete.model.Endereco;
import com.sigabem.calculadoradefrete.util.Util;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class CepService {
    static String webService = "http://viacep.com.br/ws/";
    static int codigoSucesso = 200;

    public Endereco buscaEnderecoPelo(String cep) throws Exception {
        String urlParaChamada = webService + cep + "/json";

        try {
            URL url = new URL(urlParaChamada);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != codigoSucesso)
                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            String jsonEmString = Util.converteJsonEmString(resposta);

            Gson gson = new Gson();
            return gson.fromJson(jsonEmString, Endereco.class);
        } catch (Exception e) {
            throw new Exception("ERRO: " + e);
        }
    }
}
