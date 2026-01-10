package com.petstore.user.dto;

import lombok.Builder;

/**
 * user-service
 *
 * @author Juliane Maran
 * @since 10/01/2026
 */
@Builder
public record UserResponse(
  Long id,
  String username,
  String firstName,
  String lastName,
  String email,
  String phoneNumber,
  Integer userStatus
) {
}
