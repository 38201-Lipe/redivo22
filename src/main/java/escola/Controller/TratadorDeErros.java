package escola.controller;

import escola.service.ConflitoException;
import escola.service.SalaNaoEncontradaException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Traduz as exceções da Service para o status HTTP certo.
@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(SalaNaoEncontradaException.class)
    public ResponseEntity<Map<String, String>> naoEncontrada(SalaNaoEncontradaException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("erro", ex.getMessage())); // 404
    }

    @ExceptionHandler(ConflitoException.class)
    public ResponseEntity<Map<String, String>> conflito(ConflitoException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("erro", ex.getMessage())); // 409
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> dadosInvalidos(MethodArgumentNotValidException ex) {
        Map<String, String> campos = new LinkedHashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(erro -> campos.put(erro.getField(), erro.getDefaultMessage()));
        return ResponseEntity.badRequest().body(Map.of("erro", "Dados inválidos", "campos", campos)); // 400
    }
}