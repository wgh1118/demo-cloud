package com.wanggh.cloud.authorization.rpc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/current")
public class UserController {

    @GetMapping
    public Principal getUser(Principal principal) {
        System.out.println(">>>>>>>>>>>");
        System.out.println(principal.getName());
        System.out.println(">>>>>>>>>>>");
        return principal;

    }
}