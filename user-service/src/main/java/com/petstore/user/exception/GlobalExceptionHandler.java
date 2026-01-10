package com.petstore.user.exception;

import org.jspecify.annotations.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * user-service
 *
 * @author Juliane Maran
 * @since 10/01/2026
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<@NonNull ErrorResponse> handleUserNotFoundException(UserNotFoundException ex) {
    var response = ErrorResponse.builder()
      .code(HttpStatus.NOT_FOUND.value())
      .message(ex.getMessage())
      .build();
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
  }

  @ExceptionHandler(UserAlreadyExistsException.class)
  public ResponseEntity<@NonNull ErrorResponse> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
    var response = ErrorResponse.builder()
      .code(HttpStatus.CONFLICT.value())
      .message(ex.getMessage())
      .build();
    return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
  }

}
