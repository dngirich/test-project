package com.test;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ZipCodeNotFoundException.class,LocationNotFoundException.class})
    public void handleException(HttpServletResponse response, Exception e) throws IOException {
        if (e instanceof ZipCodeNotFoundException) {
            response.sendError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }
        if (e instanceof LocationNotFoundException) {
            response.sendError(HttpStatus.NOT_FOUND.value(), e.getMessage());
        }
    }
}
