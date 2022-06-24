package com.gunt.springboot_REST_API.service;

import com.gunt.springboot_REST_API.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserServise extends UserDetailsService {
    void createUser(User user);

    Iterable<User> getAllUsers();

    void updateUser(User user);

    void deleteUser(User user);

    Optional<User> getUserById(Long id);

    void deleteUserById(Long id);

    User getUserByLogin(String login);
}
