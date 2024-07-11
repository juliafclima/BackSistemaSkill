package br.com.julia.projeto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidResourceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidResourceException(String message) {
        super(message);
    }
}