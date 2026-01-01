package com.bhaava.chatflow.common.core.response;

import lombok.Builder;

import java.time.Instant;
import java.util.Map;

@Builder
public record ApiError(
    String errorCode,
    String message,
    String correlationId,
    Instant timestamp,
    Map<String, Object> details
) {}
