package com.wanggh.cloud.pay.feign;

import org.springframework.stereotype.Component;

@Component
public class UserServiceFallback implements UserService {

    @Override
    public Integer port() {
        return -1;
    }
}
