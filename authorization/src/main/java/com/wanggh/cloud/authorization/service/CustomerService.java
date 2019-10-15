package com.wanggh.cloud.authorization.service;


import com.wanggh.cloud.authorization.entity.User;
import com.wanggh.cloud.authorization.entity.User2Role;
import com.wanggh.cloud.authorization.repository.RoleRepository;
import com.wanggh.cloud.authorization.repository.User2RoleRepository;
import com.wanggh.cloud.authorization.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wanggh
 */
@Service
public class CustomerService implements UserDetailsService {
    @Resource
    private UserRepository userRepository;

    @Resource
    private RoleRepository roleRepository;

    @Resource
    private User2RoleRepository user2RoleRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                this.getGrantedAuthorities(user.getId()));
    }

    private List<GrantedAuthority> getGrantedAuthorities(Long userId) {
        List<User2Role> user2RoleList = user2RoleRepository.findByUserId(userId);
        return user2RoleList.stream()
                .map(user2Role -> new SimpleGrantedAuthority(roleRepository.findById(user2Role.getRoleId()).get().getName()))
                .collect(Collectors.toList());
    }
}