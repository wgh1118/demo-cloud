package com.wanggh.cloud.order;

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