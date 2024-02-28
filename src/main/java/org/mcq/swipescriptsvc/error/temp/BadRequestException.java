package org.mcq.swipescriptsvc.error.temp;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }
}
