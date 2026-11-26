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
       /* if(cep== null || !cep.matches("\\d{8}")){
            throw new CepException.CepInvalidoException("CEP deve conter no mínimo 8 caracteres! ");
        }*/
        // note: para mim faz mais a validacao do cep deste modo do que o acima
        if (cep.length() != 8) {
            throw new CepException.CepInvalidoException(
                    "O CEP deve conter exatamente 8 caracteres."
            );
        }

        if (!cep.matches("\\d+")) {
            throw new CepException.CepInvalidoException(
                    "O CEP deve conter apenas números."
            );
        }
        return cepClient.consultaCep(cep);
    }

}
