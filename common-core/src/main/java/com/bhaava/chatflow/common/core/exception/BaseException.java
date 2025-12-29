package com.bhaava.chatflow.common.core.exception;

import com.bhaava.chatflow.common.core.enums.ErrorCode;

import java.util.Map;

public abstract class BaseException extends RuntimeException {

    private final ErrorCode errorCode;
    private final Map<String, Object> metadata;

    protected BaseException(String message, ErrorCode errorCode,
                            Map<String, Object> metadata) {
        super(message);
        this.errorCode = errorCode;
        this.metadata = metadata;
    }

    public ErrorCode getErrorCode() { return errorCode; }
    public Map<String, Object> getMetadata() { return metadata; }
}
