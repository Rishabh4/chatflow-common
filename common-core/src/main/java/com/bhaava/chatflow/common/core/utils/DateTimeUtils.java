package com.bhaava.chatflow.common.core.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public final class DateTimeUtils {

    private static final DateTimeFormatter ISO_FORMATTER =
            DateTimeFormatter.ISO_INSTANT.withZone(ZoneId.of("UTC"));

    private DateTimeUtils() {}

    public static Instant now() {
        return Instant.now();
    }

    public static String format(Instant instant) {
        return ISO_FORMATTER.format(instant);
    }
}
