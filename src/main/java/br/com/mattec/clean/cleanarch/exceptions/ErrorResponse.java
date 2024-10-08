package br.com.mattec.clean.cleanarch.exceptions;

import lombok.Data;

@Data
public class ErrorResponse {
    private int statusCode;
    private String message;
    private String path;

    public ErrorResponse(int statusCode, String message, String path) {
        this.statusCode = statusCode;
        this.message = message;
        this.path = path;
    }
}
