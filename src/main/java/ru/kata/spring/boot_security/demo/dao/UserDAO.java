package ru.kata.spring.boot_security.demo.dao;


import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserDAO {
    User getUserById(int id);
    User getUserByEmail(String email);
    List<User> getUserList();
    void saveUser(User user);
    void deleteUser(int id);
}
