package com.bhaava.chatflow.common.core.exception;

import com.bhaava.chatflow.common.core.enums.ErrorCode;

import java.util.Map;

public class ValidationException extends BaseException {

    public ValidationException(String resource, String id) {
        super(
                resource + " is invalid with id=" + id,
                ErrorCode.INVALID_REQUEST,
                Map.of("resource", resource, "id", id)
        );
    }
}
