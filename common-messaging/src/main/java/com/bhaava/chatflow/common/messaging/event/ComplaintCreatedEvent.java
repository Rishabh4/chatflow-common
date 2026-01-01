package com.bhaava.chatflow.common.messaging.event;

public record ComplaintCreatedEvent(
    String complaintId,
    String userId,
    String category
) {}
