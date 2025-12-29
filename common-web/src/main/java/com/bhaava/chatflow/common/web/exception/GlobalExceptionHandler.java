package com.bhaava.chatflow.common.web.exception;

import com.bhaava.chatflow.common.core.enums.ErrorCode;
import com.bhaava.chatflow.common.core.exception.BaseException;
import com.bhaava.chatflow.common.core.response.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    public static final String CORRELATION_ID = "correlationId";

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ApiError> handleBaseException(BaseException ex) {

        // Business & known errors
        log.error("Handled exception | code={} | message={} | meta={}",
                ex.getErrorCode(),
                ex.getMessage(),
                ex.getMetadata());

        ApiError error = ApiError.builder()
                .errorCode(ex.getErrorCode().name())
                .message(ex.getMessage())
                .correlationId(MDC.get(CORRELATION_ID))
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidationException(
            MethodArgumentNotValidException ex) {

        Map<String, Object> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        FieldError::getDefaultMessage,
                        (a, b) -> a
                ));

        log.warn("Validation failed | errors={}", errors);

        return ResponseEntity
                .badRequest()
                .body(ApiError.builder()
                        .errorCode(ErrorCode.INVALID_REQUEST.name())
                        .message(ex.getMessage())
                        .details(errors)
                        .correlationId(MDC.get(CORRELATION_ID))
                        .timestamp(Instant.now())
                        .build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleUnhandledException(Exception ex) {

        // System errors → ERROR
        log.error("Unhandled system exception", ex);

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiError.builder()
                        .errorCode(ErrorCode.INTERNAL_ERROR.name())
                        .message(ex.getMessage())
                        .correlationId(MDC.get(CORRELATION_ID))
                        .timestamp(Instant.now())
                        .build());
    }
}

