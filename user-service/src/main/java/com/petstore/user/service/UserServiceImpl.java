package com.petstore.user.service;

import com.petstore.user.model.User;
import com.petstore.user.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * user-service
 *
 * @author Juliane Maran
 * @since 09/01/2026
 */
@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User createUser(User user) {
    return null;
  }

  @Override
  public User getUserByName(String username) {
    return null;
  }

  @Override
  public User updateUser(String username, User user) {
    return null;
  }

  @Override
  public void deleteUser(String username) {

  }

}
