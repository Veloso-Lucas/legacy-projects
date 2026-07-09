package com.lvb.project.mscreditassessor.exception;

public class CustomerDataNotFoundException extends RuntimeException {
    public CustomerDataNotFoundException() {
        super("Customer data not found for the informed cpf");
    }
}
