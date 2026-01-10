package com.petstore.user.service;

import com.petstore.user.exception.UserNotFoundException;
import com.petstore.user.model.User;
import com.petstore.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * user-service
 *
 * @author Juliane Maran
 * @since 09/01/2026
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public User createUser(User user) {
    return null;
  }

  @Override
  public User getUserByName(String username) {
    return userRepository.findByUsername(username)
      .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado: " + username));
  }

  @Override
  public User updateUser(String username, User user) {
    return null;
  }

  @Override
  public void deleteUser(String username) {

  }

}
