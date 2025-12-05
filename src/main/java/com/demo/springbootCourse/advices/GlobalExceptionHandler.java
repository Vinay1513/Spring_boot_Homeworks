package com.demo.week1Homework.advices;

import com.demo.week1Homework.exceptions.ResourseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {


//    @ExceptionHandler(ResourseNotFoundException.class)
//    public ResponseEntity<ApiError> handleResourseNotFound(ResourseNotFoundException e) {
//        ApiError apiError = ApiError.builder().
//                status(HttpStatus.NOT_FOUND).
//
//                message(e.getMessage()).
//                build();
//        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
//
//    }

    @ExceptionHandler(ResourseNotFoundException.class)
    public ResponseEntity handleResourseNotFound(ResourseNotFoundException e) {
        ApiError apiError = ApiError.builder().
                status(HttpStatus.NOT_FOUND).

                message(e.getMessage()).
                build();
return  buildErrorResponse(apiError);
    }


//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ApiError> handleInternalServarError(Exception e) {
//        ApiError apiError = ApiError.builder()
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .message(e.getMessage()).
//                build();
//        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleInternalServarError(Exception e) {
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(e.getMessage()).
                build();
        return  buildErrorResponse(apiError);
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ApiError> handleInputValidationException(MethodArgumentNotValidException e) {
//         List<String> errors = e.getBindingResult().
//                getAllErrors().
//                stream()
//                .map(error -> error.getDefaultMessage())
//                .collect(Collectors.toList());
//
//
//                ApiError apiError = ApiError.builder().
//                        status(HttpStatus.BAD_REQUEST)
//                        .message("Input validation failed.").
//                        subErrors(errors).
//                        build();
//                return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
//    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleInputValidationException(MethodArgumentNotValidException e) {
        List<String> errors = e.getBindingResult().
                getAllErrors().
                stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());


        ApiError apiError = ApiError.builder().
                status(HttpStatus.BAD_REQUEST)
                .message("Input validation failed.").
                subErrors(errors).
                build();
        return  buildErrorResponse(apiError);
    }


    private ResponseEntity<ApiResponse<?>>buildErrorResponse(ApiError apiError) {
        return new ResponseEntity<>(new ApiResponse(apiError), apiError.getStatus());
    }

}
