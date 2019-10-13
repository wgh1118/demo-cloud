package com.wanggh.cloud.nacos.user.rest;

import com.wanggh.cloud.nacos.user.entity.User;
import com.wanggh.cloud.nacos.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wanggh
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable(value = "id") Long id) {
        return userService.findById(id);
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PatchMapping("/{id}")
    public User update(@PathVariable(value = "id") Long id, @RequestBody User user) {
        user.setId(id);
        return userService.save(user);
    }
}