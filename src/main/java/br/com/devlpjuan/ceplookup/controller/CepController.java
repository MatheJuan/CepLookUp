package br.com.devlpjuan.ceplookup.controller;

import br.com.devlpjuan.ceplookup.dto.EnderecoDto;
import br.com.devlpjuan.ceplookup.service.CepService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@ResponseBody
@RequestMapping("/api/ceps")
public class CepController {
        private final CepService service;

        public CepController(CepService service) {
            this.service = service;
        }
        @GetMapping("/{cep}")
        public ResponseEntity<EnderecoDto> consulta(@PathVariable String cep) throws IOException, InterruptedException {

            return ResponseEntity.ok(service.buscarCep(cep));
        }
}
