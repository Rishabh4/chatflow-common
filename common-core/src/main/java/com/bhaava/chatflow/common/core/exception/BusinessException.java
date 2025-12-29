package com.bhaava.chatflow.common.core.exception;

import com.bhaava.chatflow.common.core.enums.ErrorCode;

import java.util.Map;

public class BusinessException extends BaseException {

    public BusinessException(String message) {
        super(message, ErrorCode.BUSINESS_RULE_FAILED, null);
    }

    public BusinessException(String message, Map<String, Object> meta) {
        super(message, ErrorCode.BUSINESS_RULE_FAILED, meta);
    }
}
