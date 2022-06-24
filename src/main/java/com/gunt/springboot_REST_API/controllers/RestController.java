package com.gunt.springboot_REST_API.controllers;


import com.gunt.springboot_REST_API.entity.Role;
import com.gunt.springboot_REST_API.entity.User;
import com.gunt.springboot_REST_API.service.RoleServise;
import com.gunt.springboot_REST_API.service.UserServise;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    private final UserServise userServise;
    private final RoleServise roleServise;

    public RestController(UserServise userServise, RoleServise roleServise) {
        this.userServise = userServise;
        this.roleServise = roleServise;
    }

    @GetMapping("/user")
    public ResponseEntity<User> getAuthorizedUser() {
        User authorized = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok().body(authorized);
    }

    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        return ResponseEntity.ok().body(userServise.getAllUsers());
    }

    @GetMapping("/roles")
    public ResponseEntity<Iterable<Role>> getAllRoles() {
        return ResponseEntity.ok().body(roleServise.getAllRoles());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok().body(userServise.getUserById(id));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        userServise.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userServise.createUser(user);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/user")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        userServise.updateUser(user);
        return ResponseEntity.ok().body(user);
    }

}
