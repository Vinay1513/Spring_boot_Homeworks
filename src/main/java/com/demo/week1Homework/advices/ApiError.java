package com.demo.week1Homework.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.util.List;

@Data
@Builder
public class ApiError {
    private HttpStatus status;
    private String message;
    private List<String> subErrors;
}
