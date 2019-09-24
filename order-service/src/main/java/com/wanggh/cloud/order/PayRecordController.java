package com.wanggh.cloud.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wanggh
 */
@RestController
@RequestMapping(value = "/pay/records")
public class PayRecordController {
    @Autowired
    private PayRecordService payRecordService;

    @GetMapping(value = "/{id}")
    public PayRecord findById(@PathVariable(value = "id") Long id) {
        return payRecordService.findById(id);
    }

    @GetMapping
    public List<PayRecord> findAll() {
        return payRecordService.findAll();
    }

    @PostMapping
    public PayRecord save(@RequestBody PayRecord payRecord) {
        return payRecordService.save(payRecord);
    }
}