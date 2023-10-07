package jrs.todomongo.todomongo.exception;

public class OperationNotValidException extends RuntimeException {

    public OperationNotValidException(String message) {
        super(message);
    }
    
}
