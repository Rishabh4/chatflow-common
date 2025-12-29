package com.bhaava.chatflow.common.core.exception;

import com.bhaava.chatflow.common.core.enums.ErrorCode;

import java.util.Map;

public class DuplicateResourceException extends BaseException {

    public DuplicateResourceException(String resource, String field) {
        super(
                resource + " already exists with " + field,
                ErrorCode.DUPLICATE_RESOURCE,
                Map.of("resource", resource, "field", field)
        );
    }
}
