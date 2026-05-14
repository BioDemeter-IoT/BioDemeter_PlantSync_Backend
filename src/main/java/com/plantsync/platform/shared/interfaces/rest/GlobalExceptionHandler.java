package com.plantsync.platform.shared.interfaces.rest;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handler for REST controllers.
 * Handles validation errors and other common exceptions.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

  /**
   * Handles validation errors from {@link MethodArgumentNotValidException}.
   *
   * @param ex The exception to handle.
   * @return A {@link ResponseEntity} containing a map of field errors.
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleValidationErrors(
      MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getFieldErrors()
        .forEach(e -> errors.put(e.getField(), e.getDefaultMessage()));
    return ResponseEntity.badRequest().body(errors);
  }
}