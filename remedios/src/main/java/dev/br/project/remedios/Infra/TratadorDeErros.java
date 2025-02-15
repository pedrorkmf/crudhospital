package dev.br.project.remedios.Infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//Toda vez que o spring não achar o Id como por exemplo nunca foi criado, ele vai retornar o 404 pois não existe. m
@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> tratador404(){
 return ResponseEntity.notFound().build();
    }
}
