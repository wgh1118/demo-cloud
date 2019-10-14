package com.wanggh.cloud.es.controller;

import com.wanggh.cloud.es.entity.User;
import com.wanggh.cloud.es.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author liuwg-a
 * @date 2018/9/18 10:43
 * @description
 */
@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User save(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public Iterable<User> list() {
        return userRepository.findAll();
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable("id") String id) {
        userRepository.deleteById(id);
        return id;
    }
}