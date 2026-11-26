package br.com.devlpjuan.ceplookup.client;

import br.com.devlpjuan.ceplookup.dto.EnderecoDto;
import br.com.devlpjuan.ceplookup.exception.CepException;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class CepClient {

    private final HttpClient client;
    private final ObjectMapper mapper;

    public CepClient(HttpClient client, ObjectMapper mapper) {
        this.client = client;
        this.mapper = mapper;
    }

    public EnderecoDto consultaCep(String cep) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://viacep.com.br/ws/"+ cep +"/json"))
                    .GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return mapper.readValue(
                    response.body(),
                    EnderecoDto.class);

        } catch (IOException e) {
            throw new CepException.ViaCepException("Falha na comunicacao.",e);
        } catch (InterruptedException e) {
            throw new CepException.ViaCepTimeoutException("Requisicao interrompida",e);
        }


    }


}
