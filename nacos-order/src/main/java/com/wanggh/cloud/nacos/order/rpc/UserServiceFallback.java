package com.wanggh.cloud.nacos.order.rpc;

import com.wanggh.cloud.nacos.order.rpc.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceFallback implements UserService {

    private User user;

    public UserServiceFallback() {
        User user = new User();
        user.setId(-1L);
    }

    @Override
    public User findById(Long id) {

        return user;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>();
    }

    @Override
    public User save(User user) {
        return user;
    }
}
