package org.mcq.swipescriptsvc.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleAllUncaughtExceptions() {

        ApiError apiError = ApiError.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("An unexpected error occured")
                .build();

        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RegistrationException.class)
    public ResponseEntity<ApiError> handleRegistrationExceptions(RegistrationException ex) {

        ApiError apiError = ApiError.builder()
                .status(HttpStatus.CONFLICT.value())
                .message(ex.getMessage())
                .build();

        return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(LoginException.class)
    public ResponseEntity<ApiError> handleLoginExceptions(LoginException ex) {
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.UNAUTHORIZED.value())
                .message(ex.getMessage())
                .build();

        return new ResponseEntity<>(apiError, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> handleNotFoundExceptions(NotFoundException ex) {

        ApiError apiError = ApiError.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .build();

        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidationExceptions(MethodArgumentNotValidException ex) {

        String errors = ex.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(", "));

        ApiError apiError = ApiError.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .message(errors)
                .build();

        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }



    // todo added for testing - might remove
//    @ExceptionHandler(BadRequestException.class)
//    public ResponseEntity<ApiError> handleBadRequestExceptions(BadRequestException ex) {
//        ApiError apiError = ApiError.builder()
//                .status(HttpStatus.BAD_REQUEST.value())
//                .message(ex.getMessage())
//                .build();
//
//        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
//    }
//
//    // todo added for testing - might remove
//    @ExceptionHandler(UnauthorizedException.class)
//    public ResponseEntity<ApiError> handleUnauthorizedExceptions(UnauthorizedException ex) {
//        ApiError apiError = ApiError.builder()
//                .status(HttpStatus.UNAUTHORIZED.value())
//                .message(ex.getMessage())
//                .build();
//
//        System.out.println("HEY IT WORKED");
//        return new ResponseEntity<>(apiError, HttpStatus.UNAUTHORIZED);
//    }
}
