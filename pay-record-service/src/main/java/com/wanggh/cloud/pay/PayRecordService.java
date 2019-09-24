package com.wanggh.cloud.pay;

import java.util.List;

public interface PayRecordService {
    /**
     * findById
     *
     * @param id
     * @return
     */
    PayRecord findById(Long id);

    /**
     * findByAll
     *
     * @return
     */
    List<PayRecord> findAll();

    /**
     * save
     *
     * @param payRecord
     * @return
     */
    PayRecord save(PayRecord payRecord);
}