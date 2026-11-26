package br.com.devlpjuan.ceplookup.controller;

import br.com.devlpjuan.ceplookup.dto.EnderecoDto;
import br.com.devlpjuan.ceplookup.service.CepService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ceps")
public class CepController {
        private final CepService service;

        public CepController(CepService service) {
            this.service = service;
        }

        @GetMapping("/{cep}")
        public ResponseEntity<EnderecoDto> consulta(@PathVariable String cep){
            return ResponseEntity.ok(service.buscarCep(cep));
        }
}
