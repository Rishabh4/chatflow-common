package com.bhaava.chatflow.common.security.annotation;

import com.bhaava.chatflow.common.security.config.ChatFlowSecurityConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(ChatFlowSecurityConfig.class)
public @interface EnableChatFlowSecurity {
}
