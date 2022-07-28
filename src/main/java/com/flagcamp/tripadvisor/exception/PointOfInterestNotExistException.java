package com.flagcamp.tripadvisor.exception;

public class PointOfInterestNotExistException extends RuntimeException{
    public PointOfInterestNotExistException(String message) {
        super(message);
    }
}

