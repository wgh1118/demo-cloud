package com.wanggh.cloud.nacos.order.rpc;


import com.wanggh.cloud.nacos.order.rpc.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "nacos-user", fallback = UserServiceFallback.class)
@Component
public interface UserService {

    @GetMapping("/users/{id}")
    User findById(@PathVariable(value = "id") Long id);

    @GetMapping("/users")
    List<User> findAll();

    @PostMapping("/users/{id}")
    User save(@RequestBody User user);
}