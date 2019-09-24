package com.wanggh.cloud.pay;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author wanggh
 */
@Service
public class PayRecordServiceImpl implements PayRecordService {
    @Resource
    private PayRecordRepository payRecordRepository;

    @Override
    public PayRecord findById(Long id) {
        Optional<PayRecord> userOptional = payRecordRepository.findById(id);
        return userOptional.orElse(null);
    }

    @Override
    public List<PayRecord> findAll() {
        return payRecordRepository.findAll();
    }

    @Override
    public PayRecord save(PayRecord payRecord) {
        return payRecordRepository.save(payRecord);
    }
}