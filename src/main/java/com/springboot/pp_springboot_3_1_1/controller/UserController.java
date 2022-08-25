package com.springboot.pp_springboot_3_1_1.controller;

import com.springboot.pp_springboot_3_1_1.model.User;
import com.springboot.pp_springboot_3_1_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAllUsers(Model model) {
        model.addAttribute("user", userService.getAllUsers());
        return "userList";
    }

    @GetMapping("/create")
    public String createEmptyUserForm(@ModelAttribute User user) {
        return "/createUser";
    }

    @PostMapping("/createUser")
    public String createUserWithDetails(@ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateUserById(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "/updateUser";
    }

    @PostMapping("/userUpdate")
    public String updateUser(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}
