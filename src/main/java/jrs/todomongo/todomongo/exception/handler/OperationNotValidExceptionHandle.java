package jrs.todomongo.todomongo.exception.handler;

import java.time.Instant;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import jrs.todomongo.todomongo.exception.OperationNotValidException;
import jrs.todomongo.todomongo.exception.dto.ExceptionDefaultDTO;

@RestControllerAdvice
public class OperationNotValidExceptionHandle {
    
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(OperationNotValidException.class)
    public ExceptionDefaultDTO handle(OperationNotValidException exception, WebRequest request){
        return ExceptionDefaultDTO
            .builder()
            .timestamp(Instant.now())
            .message(exception.getMessage())
            .status(HttpStatus.BAD_REQUEST.value())
            .path(request.getDescription(false).split("=")[1])
            .build();
    }
}
