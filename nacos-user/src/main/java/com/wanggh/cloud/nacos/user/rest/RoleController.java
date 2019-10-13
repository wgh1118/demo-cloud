package com.wanggh.cloud.nacos.user.rest;

import com.wanggh.cloud.nacos.user.entity.Role;
import com.wanggh.cloud.nacos.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wanggh
 */
@RestController
@RequestMapping(value = "/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/{id}")
    public Role findById(@PathVariable(value = "id") Long id) {
        return roleService.findById(id);
    }

    @GetMapping
    public List<Role> findAll() {
        return roleService.findAll();
    }

    @PostMapping
    public Role save(@RequestBody Role user) {
        return roleService.save(user);
    }
}