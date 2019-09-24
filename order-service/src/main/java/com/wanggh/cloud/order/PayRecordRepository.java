package com.wanggh.cloud.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wanggh
 */
@Repository
public interface PayRecordRepository extends JpaRepository<PayRecord, Long> {
}