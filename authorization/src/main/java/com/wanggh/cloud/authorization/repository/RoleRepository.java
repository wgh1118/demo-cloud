package com.wanggh.cloud.authorization.repository;

import com.wanggh.cloud.authorization.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wanggh
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}