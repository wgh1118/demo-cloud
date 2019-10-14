package com.wanggh.cloud.gateway.controller;


import com.wanggh.cloud.gateway.entity.GatewayPredicateDefinition;
import com.wanggh.cloud.gateway.entity.GatewayRouteDefinition;
import com.wanggh.cloud.gateway.service.GatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteController {

    @Autowired
    private GatewayService gatewayService;

    @PostMapping("/add")
    public String add(@RequestBody GatewayRouteDefinition gateway) {
        try {
            RouteDefinition definition = assembleRouteDefinition(gateway);
            return this.gatewayService.add(definition);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "succss";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        return this.gatewayService.delete(id);
    }

    @PostMapping("/update")
    public String update(@RequestBody GatewayRouteDefinition gateway) {
        RouteDefinition definition = assembleRouteDefinition(gateway);
        return this.gatewayService.update(definition);
    }

    private RouteDefinition assembleRouteDefinition(GatewayRouteDefinition gateway) {
        RouteDefinition definition = new RouteDefinition();
        List<PredicateDefinition> pdList = new ArrayList<>();
        definition.setId(gateway.getId());
        List<GatewayPredicateDefinition> gatewayPredicateDefinitionList = gateway.getPredicates();
        for (GatewayPredicateDefinition gpDefinition : gatewayPredicateDefinitionList) {
            PredicateDefinition predicate = new PredicateDefinition();
            predicate.setArgs(gpDefinition.getArgs());
            predicate.setName(gpDefinition.getName());
            pdList.add(predicate);
        }
        definition.setPredicates(pdList);
        URI uri = UriComponentsBuilder.fromHttpUrl(gateway.getUri()).build().toUri();
        definition.setUri(uri);
        return definition;
    }

}
