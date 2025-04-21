package com.movie.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class DuplicationException extends RuntimeException {
    public DuplicationException(String message) {
        super(message);
    }
}
