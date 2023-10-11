package com.ipze.self_assessment.exceptions.custom;

/**
 * @author Igor Hnes on 24.11.2020.
 */
public class WrongOperationException extends RuntimeException {

    public WrongOperationException() {
    }

    public WrongOperationException(String message) {
        super(message);
    }
}
