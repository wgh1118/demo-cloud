package com.wanggh.cloud.pay.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "user-service", fallback = UserServiceFallback.class)
@Component
public interface UserService {
    @GetMapping("/users/ports")
    Integer port();
}
