package com.petstore.user.controller;

import com.petstore.user.model.User;
import com.petstore.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * user-service
 *
 * @author Juliane Maran
 * @since 09/01/2026
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping
  public ResponseEntity<@NonNull User> createUser(@RequestBody User user) {
    userService.createUser(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(null);
  }

  @GetMapping("/{username}")
  public ResponseEntity<@NonNull User> getUserByName(@PathVariable String username) {
    User user = userService.getUserByName(username);
    return ResponseEntity.status(HttpStatus.OK).body(user);
  }

  @PutMapping("/{username}")
  public ResponseEntity<@NonNull User> updateUser(@PathVariable String username, @RequestBody User user) {
    userService.updateUser(username, user);
    return ResponseEntity.status(HttpStatus.OK).body(null);
  }

  @PutMapping("/{username}")
  public ResponseEntity<@NonNull Void> deleteUser(@PathVariable String username) {
    userService.deleteUser(username);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

}
