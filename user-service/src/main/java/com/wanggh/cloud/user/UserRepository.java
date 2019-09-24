package com.wanggh.cloud.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wanggh
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}