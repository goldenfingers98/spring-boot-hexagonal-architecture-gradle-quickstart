package tn.ksoftwares.hexagonal.domain.model.exception;

public class FailedSerializationException extends RuntimeException {

    public FailedSerializationException(String message) {
        super(message);
    }
    
}
