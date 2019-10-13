package com.wanggh.cloud.nacos.order.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.wanggh.cloud.nacos.order.repository.OrderRepository;
import com.wanggh.cloud.nacos.order.entity.OrderRecord;
import com.wanggh.cloud.nacos.order.rpc.UserService;
import com.wanggh.cloud.nacos.order.rpc.entity.User;
import com.wanggh.cloud.nacos.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author wanggh
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;

    @Override
    public OrderRecord findById(Long id) {
        Optional<OrderRecord> userOptional = orderRepository.findById(id);
        return userOptional.orElse(null);
    }

    @Override
    public List<OrderRecord> findAll() {
        return orderRepository.findAll();
    }

    @Transactional
    @LcnTransaction
    @Override
    public OrderRecord save(OrderRecord orderRecord) {
        User user = userService.findById(orderRecord.getUserId());
        if (user.getBalance() > orderRecord.getPrice()) {
            user.setBalance(user.getBalance() - orderRecord.getPrice());
            userService.save(user);
            if (user.getBalance() < 5) {
                throw new RuntimeException("Test");
            }
            orderRepository.save(orderRecord);
        }
        return orderRecord;
    }
}