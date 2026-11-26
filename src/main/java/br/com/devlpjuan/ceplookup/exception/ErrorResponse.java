package br.com.devlpjuan.ceplookup.exception;

import java.time.Instant;


public record ErrorResponse(
        int status,
        String message,
        Instant timestamp
) {}
