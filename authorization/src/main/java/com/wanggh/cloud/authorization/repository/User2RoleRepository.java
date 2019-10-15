package com.wanggh.cloud.authorization.repository;

import com.wanggh.cloud.authorization.entity.User2Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wanggh
 */
@Repository
public interface User2RoleRepository extends JpaRepository<User2Role, Long> {
    List<User2Role> findByUserId(Long userId);
}