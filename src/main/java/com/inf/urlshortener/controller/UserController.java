package com.inf.urlshortener.controller;


import com.inf.urlshortener.model.User;
import com.inf.urlshortener.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/user")
    public User save(@RequestBody User user) {
        userService.saveUser(user);
        return user;

    }

}
