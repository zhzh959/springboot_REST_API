package com.gunt.springboot_REST_API.service;

import com.gunt.springboot_REST_API.dao.RoleRepository;
import com.gunt.springboot_REST_API.entity.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoleServiseImpl implements RoleServise {
    private final RoleRepository roleRepository;


    public RoleServiseImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public void creatRoles(Set<Role> roles) {
        roleRepository.saveAll(roles);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Role> getAllRoles() {
        Iterable<Role> iterable = roleRepository.findAll();
        Set<Role> set = new HashSet<>();
        iterable.forEach(role -> set.add(role));
        return set;
    }
}
