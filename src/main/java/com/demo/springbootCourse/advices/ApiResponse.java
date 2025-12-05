package com.demo.week1Homework.advices;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ApiResponse<T>{
    private T data;
    private LocalDateTime timestamp;
    private ApiError error;
    public ApiResponse() {
this.timestamp = LocalDateTime.now();

    }

    public ApiResponse(T data) {
        this();
        this.data = data;
    }

    public ApiResponse(T data, ApiError error) {
        this();
        this.error = error;
    }
}
