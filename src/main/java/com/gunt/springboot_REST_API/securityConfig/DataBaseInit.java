package com.gunt.springboot_REST_API.securityConfig;

import com.gunt.springboot_REST_API.entity.Role;
import com.gunt.springboot_REST_API.entity.User;
import com.gunt.springboot_REST_API.service.RoleServise;
import com.gunt.springboot_REST_API.service.UserServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataBaseInit {
    private final UserServise userService;
    private final RoleServise roleService;

    @Autowired
    public DataBaseInit(UserServise userService, RoleServise roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void dataBaseInit() {
        Set<Role> allRoles = new HashSet<>();
        allRoles.add(new Role("ADMIN"));
        allRoles.add(new Role("USER"));

        roleService.creatRoles(allRoles);

        User admin = new User("Petr", "Petrov", (byte) 22, "pet@pet.com", "admin",
                "admin");
        admin.setRoles("ADMIN, USER");
        userService.createUser(admin);
        User user = new User("Sergey", "Sergeev", (byte) 55, "ser@ser.com", "user",
                "user");
        user.setRoles("USER");
        userService.createUser(user);
    }
}
