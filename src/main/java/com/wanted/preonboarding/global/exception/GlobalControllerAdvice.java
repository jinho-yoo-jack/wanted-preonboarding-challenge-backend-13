package com.wanted.preonboarding.global.exception;

import com.wanted.preonboarding.global.Response;
import com.wanted.preonboarding.theater.exception.TheaterException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
public class GlobalControllerAdvice {

    @ExceptionHandler(TheaterException.class)
    public ResponseEntity<?> theaterHandler(TheaterException e) {
        log.error("Error occur {}", e.toString());
        return ResponseEntity.status(e.getErrorCode().getStatus())
                .body(Response.error(e.getErrorCode().name()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> runtimeHandler(RuntimeException e) {
        log.error("Error occur {}", e.toString());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Response.error(HttpStatus.INTERNAL_SERVER_ERROR.toString()));
    }
}
