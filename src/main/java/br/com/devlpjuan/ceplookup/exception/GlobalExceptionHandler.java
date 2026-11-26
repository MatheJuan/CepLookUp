package br.com.devlpjuan.ceplookup.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CepException.CepInvalidoException.class)
    public ResponseEntity<ErrorResponse> handleCepInvalido(CepException.CepInvalidoException e) {
        return buildResponseEntity(HttpStatus.BAD_REQUEST,e);
    }
    @ExceptionHandler(CepException.CepNaoEncontradoException.class)
    public ResponseEntity<ErrorResponse> handlerCepNaoEncontrado(
            CepException.CepNaoEncontradoException e){
        return buildResponseEntity(HttpStatus.NOT_FOUND, e);
    }
    @ExceptionHandler(CepException.ViaCepException.class)
    public ResponseEntity<ErrorResponse> handlerViaCepException(CepException.ViaCepException e) {

        return buildResponseEntity(HttpStatus.BAD_GATEWAY, e);
    }
    @ExceptionHandler(CepException.ViaCepTimeoutException.class)
    public ResponseEntity<ErrorResponse> handlerViaCepTimeOut (CepException.ViaCepTimeoutException e) {
        return buildResponseEntity(HttpStatus.GATEWAY_TIMEOUT, e);
    }

    private ResponseEntity<ErrorResponse> buildResponseEntity(HttpStatus status, Exception e){
        ErrorResponse error = new ErrorResponse(
                status.value(),
                e.getMessage(),
                Instant.now()
        );
        return ResponseEntity.status(status).body(error);
    }
}
