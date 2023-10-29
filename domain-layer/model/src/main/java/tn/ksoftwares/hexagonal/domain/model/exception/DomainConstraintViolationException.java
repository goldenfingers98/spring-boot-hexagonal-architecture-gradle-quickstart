package tn.ksoftwares.hexagonal.domain.model.exception;

public class DomainConstraintViolationException extends Exception {

    public DomainConstraintViolationException() {
    }

    public DomainConstraintViolationException(String message) {
        super(message);
    }
    
}
