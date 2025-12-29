package com.bhaava.chatflow.common.core.model;

import lombok.Data;

import java.time.Instant;

@Data
public abstract class BaseEntity {
    private String id;
    private Instant createdAt;
    private Instant updatedAt;
}
