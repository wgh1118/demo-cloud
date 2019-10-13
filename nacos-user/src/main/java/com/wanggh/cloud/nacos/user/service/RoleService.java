package com.wanggh.cloud.nacos.user.service;

import com.wanggh.cloud.nacos.user.entity.Role;

import java.util.List;

public interface RoleService {
    Role findById(Long id);

    List<Role> findAll();

    Role save(Role user);
}