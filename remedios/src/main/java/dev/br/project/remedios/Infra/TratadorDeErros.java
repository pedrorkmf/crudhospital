package dev.br.project.remedios.Infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//Toda vez que o spring não achar o Id como por exemplo nunca foi criado, ele vai retornar o 404 pois não existe. m
@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> tratador404(){
 return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> tratador400(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors();//pega todos os campos que deram erros
        return ResponseEntity.badRequest().body(erros.stream().map(DadosErros::new).toList());
    }
//criando um dto dentro desta classe pois ele so vai ser usado dentro desta classe
    public record DadosErros(String campo,String messagem){
//parametros
        public DadosErros(FieldError error){
            this(error.getField(),error.getDefaultMessage());
        }
}
}
