package ru.kata.spring.boot_security.demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.util.Set;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    private final RoleRepository roleRepository;

    @GetMapping({"/", ""})
    public String userList(Model model) {
        model.addAttribute("users", userService.getUserList());
        model.addAttribute("roles", roleRepository.findAll());
        return "user-list";
    }

    @GetMapping("/add")
    public String userAdd(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleRepository.findAll());
        return "user-edit";
    }

    @GetMapping("/{id}/edit")
    public String userEdit(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("roles", roleRepository.findAll());
        return "user-edit";
    }

    @PostMapping("/save")
    public String userSave(@ModelAttribute("user") User user,
                           @ModelAttribute("roles") Set<Role> roles) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/delete")
    public String userDelete(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
