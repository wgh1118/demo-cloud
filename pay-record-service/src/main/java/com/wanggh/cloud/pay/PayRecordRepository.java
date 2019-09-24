package com.wanggh.cloud.pay;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wanggh
 */
@Repository
public interface PayRecordRepository extends JpaRepository<PayRecord, Long> {
}