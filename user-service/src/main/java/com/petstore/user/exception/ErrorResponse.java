package com.petstore.user.exception;

import lombok.Builder;

/**
 * user-service
 *
 * @author Juliane Maran
 * @since 09/01/2026
 */
@Builder
public record ErrorResponse(
  Integer code,
  String message
) {
}
