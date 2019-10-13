package com.wanggh.cloud.nacos.order.rest;

import com.wanggh.cloud.nacos.order.service.OrderService;
import com.wanggh.cloud.nacos.order.entity.OrderRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wanggh
 */
@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/{id}")
    public OrderRecord findById(@PathVariable(value = "id") Long id) {
        return orderService.findById(id);
    }

    @GetMapping
    public List<OrderRecord> findAll() {
        return orderService.findAll();
    }

    @PostMapping
    public OrderRecord save(@RequestBody OrderRecord user) {
        return orderService.save(user);
    }
}