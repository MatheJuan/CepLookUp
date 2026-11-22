package br.com.devlpjuan.ceplookup.client;

import br.com.devlpjuan.ceplookup.dto.EnderecoDto;
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

    public EnderecoDto consultaCep(EnderecoDto cep) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/"+ cep +"/json"))
                .GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if(response.statusCode() !=200){
            throw new IOException("Erro ao consultar cep: " + response.statusCode());
        }

        return mapper.readValue(
                response.body(),
                EnderecoDto.class);
    }


}
