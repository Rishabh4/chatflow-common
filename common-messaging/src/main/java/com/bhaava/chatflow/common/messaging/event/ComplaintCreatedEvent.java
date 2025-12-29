package com.bhaava.chatflow.common.messaging.event;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ComplaintCreatedEvent {
    private String complaintId;
    private String userId;
    private String category;
}
