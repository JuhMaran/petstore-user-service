package com.petstore.user.exception;

/**
 * user-service
 *
 * @author Juliane Maran
 * @since 09/01/2026
 */
public class UserAlreadyExistsException extends RuntimeException {

  public UserAlreadyExistsException(String message) {
    super(message);
  }

}
