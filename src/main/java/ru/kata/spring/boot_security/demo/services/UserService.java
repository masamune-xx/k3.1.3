package ru.kata.spring.boot_security.demo.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    User getUserById(int id);
    User getUserByEmail(String email);
    List<User> getUserList();
    void saveUser(User user);
    void deleteUser(int id);
}
