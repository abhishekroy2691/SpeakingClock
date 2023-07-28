package com.speakingclock.exception.handler;

import java.time.format.DateTimeParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SpeakingClockExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(SpeakingClockExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public final ResponseEntity<String> handleGenericException(Exception ex) {
        logger.error("Generic Error", ex);
        return new ResponseEntity("Something went wrong. Please check and verify.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(value = DateTimeParseException.class)
    public final ResponseEntity<String> handleDateTimeParseException(Exception ex) {
        logger.error("Something went wrong with parsing of datetime", ex);
        return new ResponseEntity("Something went wrong with date time conversion logic.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
