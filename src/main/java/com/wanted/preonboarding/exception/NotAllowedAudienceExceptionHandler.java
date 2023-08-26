package com.wanted.preonboarding.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class NotAllowedAudienceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotAllowedAudienceException.class)
    protected ResponseEntity<Object> amountIsLessThanFee(NotAllowedAudienceException ex, WebRequest request){
        // log error
        logger.error(request.getLocale());
        logger.error(request.getContextPath());

        // get list of errors
        List<String> errs = new ArrayList<>();
        errs.add(ex.getErrMessage());

        // convert error to the ErrFormat
        ErrFormat errFormat = new ErrFormat(
                LocalDateTime.now(),
                ex.getStatus(),
                ex.getErrMessage(),
                errs);

        return ErrFormatResponseBuilder.build(errFormat);
    }

}
