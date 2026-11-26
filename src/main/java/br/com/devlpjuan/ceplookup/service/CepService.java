package br.com.devlpjuan.ceplookup.service;

import br.com.devlpjuan.ceplookup.client.CepClient;
import br.com.devlpjuan.ceplookup.dto.EnderecoDto;
import br.com.devlpjuan.ceplookup.exception.CepException;
import org.springframework.stereotype.Service;

@Service
public class CepService {
    private final CepClient cepClient;

    public CepService(CepClient cepClient) {
        this.cepClient = cepClient;
    }

    public EnderecoDto buscarCep(String cep){
        if(cep== null || !cep.matches("\\d{8}")){
            throw new CepException.CepInvalidoException("CEP deve conter no mínimo 8 caracteres! ");
        }
        return cepClient.consultaCep(cep);
    }

}
