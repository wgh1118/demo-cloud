package com.wanggh.cloud.nacos.user.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanggh
 */
@RefreshScope
@RestController
@RequestMapping(value = "/configs")
public class ConfigController {

    @Value("${customize.author}")
    private String author;

    @GetMapping
    public String get() {
        return author;
    }
}