package com.bhaava.chatflow.common.core.response;

public record ApiResponse<T>(
    boolean success,
    T data,
    String message
) {

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, data, null);
    }

    public static ApiResponse<Void> successMessage(String message) {
        return new ApiResponse<>(true, null, message);
    }
}
