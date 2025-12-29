package com.bhaava.chatflow.common.core.exception;

import com.bhaava.chatflow.common.core.enums.ErrorCode;

import java.util.Map;

public class ResourceNotFoundException extends BaseException {

    public ResourceNotFoundException(String resource, String id) {
        super(
                resource + " not found with id=" + id,
                ErrorCode.RESOURCE_NOT_FOUND,
                Map.of("resource", resource, "id", id)
        );
    }
}

