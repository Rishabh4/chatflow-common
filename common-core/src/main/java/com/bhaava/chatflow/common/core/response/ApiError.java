package com.bhaava.chatflow.common.core.response;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.Map;

@Data
@Builder
public class ApiError {
    private String errorCode;
    private String message;
    private String correlationId;
    private Instant timestamp;
    private Map<String, Object> details;
}
