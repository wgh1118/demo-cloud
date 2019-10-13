package com.wanggh.cloud.nacos.user.service;

import com.wanggh.cloud.nacos.user.entity.User;

import java.util.List;

public interface UserService {
    User findById(Long id);

    List<User> findAll();

    User save(User user);
}