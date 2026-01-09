package com.petstore.user.service;

import com.petstore.user.model.User;

/**
 * user-service
 *
 * @author Juliane Maran
 * @since 09/01/2026
 */
public interface UserService {

  User createUser(User user);

  User getUserByName(String username);

  User updateUser(String username, User user);

  void deleteUser(String username);

}
