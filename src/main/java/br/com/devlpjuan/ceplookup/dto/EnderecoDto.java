package br.com.devlpjuan.ceplookup.dto;

public class EnderecoDto {
    public EnderecoDto(String cep, String logradouro, String complemento, String bairro, String localidade, String uf) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }

    String  cep;
    String logradouro;
    String complemento;
    String  bairro;
    String localidade;
    String uf;

    @Override
    public String toString() {
        return "EnderecoDto{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }
}
