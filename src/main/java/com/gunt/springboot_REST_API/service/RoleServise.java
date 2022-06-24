package com.gunt.springboot_REST_API.service;

import com.gunt.springboot_REST_API.entity.Role;

import java.util.Set;

public interface RoleServise {
    void creatRoles(Set<Role> roles);
    Set<Role> getAllRoles();
}
