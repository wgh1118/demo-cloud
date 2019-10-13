package com.wanggh.cloud.nacos.order.repository;

import com.wanggh.cloud.nacos.order.entity.OrderRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wanggh
 */
@Repository
public interface OrderRepository extends JpaRepository<OrderRecord, Long> {
}