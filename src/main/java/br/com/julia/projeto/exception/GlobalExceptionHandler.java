package br.com.julia.projeto.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import br.com.julia.projeto.exception.entity.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest request) {
        String mensagemErro = "Ocorreu um erro durante a requisição: " + ex.getMessage();
        return new ResponseEntity<>(mensagemErro, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        String mensagemErro = "Recurso não encontrado: " + ex.getMessage();
        return new ResponseEntity<>(mensagemErro, HttpStatus.NOT_FOUND);
    }

    
    @ExceptionHandler(InvalidResourceException.class)
    public ResponseEntity<List<ErrorResponse>> handleInvalidResourceException(InvalidResourceException ex) {
        List<ErrorResponse> errors = new ArrayList<>();
        errors.add(new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value()));
        return ResponseEntity.badRequest().body(errors);
    }
}