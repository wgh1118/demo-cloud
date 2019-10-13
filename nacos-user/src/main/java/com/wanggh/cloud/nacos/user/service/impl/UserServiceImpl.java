package com.wanggh.cloud.nacos.user.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.wanggh.cloud.nacos.user.repository.UserRepository;
import com.wanggh.cloud.nacos.user.entity.User;
import com.wanggh.cloud.nacos.user.service.UserService;
import org.bouncycastle.util.Integers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author wanggh
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    @LcnTransaction
    @Override
    public User save(User user) {
        if (Objects.isNull(user.getBalance())) {
            user.setBalance(0);
        }
        return userRepository.save(user);
    }
}