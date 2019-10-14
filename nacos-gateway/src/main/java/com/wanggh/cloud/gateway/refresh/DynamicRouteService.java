package com.wanggh.cloud.gateway.refresh;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import com.wanggh.cloud.gateway.service.GatewayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.Executor;

@Slf4j
@Component
public class DynamicRouteService {

    @Autowired
    private GatewayService gatewayService;

    @Value("${spring.cloud.nacos.discovery.server-addr}")
    private String nacosServerAddr;

    @Value("${data-id}")
    private String configDataId;

    @Value("${group}")
    private String configGroup;

    private static final long DEFAULT_TIMEOUT = 30000;

    @PostConstruct
    public void init() {
        listener(configDataId, configGroup);
    }

    private void listener(String dataId, String group) {
        try {
            ConfigService configService = NacosFactory.createConfigService(nacosServerAddr);
            String content = configService.getConfig(dataId, group, DEFAULT_TIMEOUT);
            log.info("更新网关配置:\r\n{}", content);
            configService.addListener(dataId, group, new Listener() {
                @Override
                public void receiveConfigInfo(String configInfo) {
                    log.info("进行网关更新:\n\r{}", configInfo);
                    List<RouteDefinition> definitionList = JSON.parseArray(configInfo, RouteDefinition.class);
                    for (RouteDefinition definition : definitionList) {
                        log.info("update route : {}", definition.toString());
                        gatewayService.update(definition);
                    }
                }

                @Override
                public Executor getExecutor() {
                    return null;
                }
            });
        } catch (NacosException e) {
            log.error("从nacos接收动态路由配置出错!!!", e);
        }
    }
}
