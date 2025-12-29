package com.bhaava.chatflow.common.logging.mdc;

import org.slf4j.MDC;

public final class MDCUtil {

    private MDCUtil() {}

    public static void putCorrelationId(String id) {
        MDC.put(MDCKeys.CORRELATION_ID, id);
    }

    public static void putUserId(String userId) {
        MDC.put(MDCKeys.USER_ID, userId);
    }

    public static void clear() {
        MDC.clear();
    }
}
