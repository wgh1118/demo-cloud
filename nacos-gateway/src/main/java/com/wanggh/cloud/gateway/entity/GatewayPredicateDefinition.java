package com.wanggh.cloud.gateway.entity;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 断言
 */
@Data
public class GatewayPredicateDefinition {
    private String name;
    private Map<String, String> args = new LinkedHashMap<>();
}
