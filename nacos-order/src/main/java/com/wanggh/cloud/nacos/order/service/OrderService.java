package com.wanggh.cloud.nacos.order.service;

import com.wanggh.cloud.nacos.order.entity.OrderRecord;

import java.util.List;

public interface OrderService {
    OrderRecord findById(Long id);

    List<OrderRecord> findAll();

    OrderRecord save(OrderRecord user);
}