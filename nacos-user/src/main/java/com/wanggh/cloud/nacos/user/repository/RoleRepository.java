package com.wanggh.cloud.nacos.user.repository;

import com.wanggh.cloud.nacos.user.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wanggh
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}