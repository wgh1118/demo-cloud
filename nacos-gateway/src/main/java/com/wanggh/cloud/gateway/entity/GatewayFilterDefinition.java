package com.wanggh.cloud.gateway.entity;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class GatewayFilterDefinition {
    private String name;
    private Map<String, String> args = new LinkedHashMap<>();
}
