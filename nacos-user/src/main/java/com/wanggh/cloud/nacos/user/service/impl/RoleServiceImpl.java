package com.wanggh.cloud.nacos.user.service.impl;

import com.wanggh.cloud.nacos.user.entity.Role;
import com.wanggh.cloud.nacos.user.repository.RoleRepository;
import com.wanggh.cloud.nacos.user.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author wanggh
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleRepository roleRepository;

    @Override
    public Role findById(Long id) {
        Optional<Role> userOptional = roleRepository.findById(id);
        return userOptional.orElse(null);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }
}