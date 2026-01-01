package com.bhaava.chatflow.common.security.jwt;

import com.bhaava.chatflow.common.security.enums.UserRole;

public record JwtClaims(
    String userId,
    UserRole role
) {}
