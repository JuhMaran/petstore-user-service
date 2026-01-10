package com.petstore.user.exception;

/**
 * user-service
 *
 * @author Juliane Maran
 * @since 09/01/2026
 */
public record ErrorResponse(
  Integer code,
  String message
) {
}
