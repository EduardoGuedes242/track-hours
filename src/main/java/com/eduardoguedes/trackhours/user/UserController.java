package com.eduardoguedes.trackhours.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public List<UserEntity> listAllUsers() {
      return userService.listAllUsers();
    }

    @PostMapping
    public void createOrUpdadeNewUser(@RequestBody UserEntity user) {
      userService.createOrUpdateUser(user);
    }

}
