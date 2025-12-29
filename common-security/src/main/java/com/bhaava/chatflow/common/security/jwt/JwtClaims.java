package com.bhaava.chatflow.common.security.jwt;

import com.bhaava.chatflow.common.security.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtClaims {
    private String userId;
    private UserRole role;
}
