package com.wanggh.cloud.user;

import java.util.List;

public interface UserService {
    /**
     * findById
     *
     * @param id
     * @return
     */
    User findById(Long id);

    /**
     * findByAll
     *
     * @return
     */
    List<User> findAll();

    /**
     * save
     *
     * @param user
     * @return
     */
    User save(User user);
}