package com.springboot.pp_springboot_3_1_1.service;

import com.springboot.pp_springboot_3_1_1.model.User;


import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUser(int id);

    void createUser(User user);

    void updateUser(User user);

    void deleteUser(int id);
}
