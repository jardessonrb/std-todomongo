package jrs.todomongo.todomongo.exception.handler;

import java.time.Instant;

import org.springframework.data.mongodb.core.aggregation.StringOperators.Split;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import jrs.todomongo.todomongo.exception.EntityNotFoundException;
import jrs.todomongo.todomongo.exception.dto.ExceptionDefaultDTO;

@RestControllerAdvice
public class EntityNotFoundExceptionHandler {
    
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ExceptionDefaultDTO handle(EntityNotFoundException exception, WebRequest request){
        return ExceptionDefaultDTO
            .builder()
            .timestamp(Instant.now())
            .message(exception.getMessage())
            .status(HttpStatus.NOT_FOUND.value())
            .path(request.getDescription(false).split("=")[1])
            .build();
    }

}
