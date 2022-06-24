package com.gunt.springboot_REST_API.dao;

import com.gunt.springboot_REST_API.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository <Role, Long> {
}
