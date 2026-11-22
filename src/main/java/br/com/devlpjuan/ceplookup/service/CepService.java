package br.com.devlpjuan.ceplookup.service;

import br.com.devlpjuan.ceplookup.client.CepClient;
import br.com.devlpjuan.ceplookup.dto.EnderecoDto;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CepService {

    private final CepClient cepClient;


    public CepService(CepClient cepClient) {
        this.cepClient = cepClient;
    }

    public EnderecoDto buscarCep(String cep) throws IOException,
            InterruptedException {

        return cepClient.consultaCep(cep);
    }

}
