package com.ipze.self_assessment.exceptions.custom;

/**
 * @author Igor Hnes on 24.11.2020.
 */
public class NoSuchEntityException extends RuntimeException {

    public NoSuchEntityException() {
    }

    public NoSuchEntityException(String message) {
        super(message);
    }
}
