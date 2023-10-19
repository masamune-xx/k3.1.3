package ru.kata.spring.boot_security.demo.init;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;

import javax.annotation.PostConstruct;
import java.util.Set;

@RequiredArgsConstructor
@Component
public class DBInit {

    private final UserService userService;

    private final RoleService roleService;

    @PostConstruct
    public void init() {

        Role adminRole = new Role();
        adminRole.setName("ADMIN");
        roleService.saveRole(adminRole);

        Role userRole = new Role();
        userRole.setName("USER");
        roleService.saveRole(userRole);

        User admin = new User();
        admin.setFirstName("admin");
        admin.setLastName("admin");
        admin.setAge(40);
        admin.setEmail("admin@admin.com");
        admin.setPassword("admin");
        admin.setRoles(Set.of(adminRole, userRole));
        userService.saveUser(admin);
    }
}
