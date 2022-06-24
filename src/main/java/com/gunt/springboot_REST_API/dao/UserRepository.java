package com.gunt.springboot_REST_API.dao;

import com.gunt.springboot_REST_API.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByName(String name);

    User findUserByLogin(String login);

    void deleteById(Long id);
}
