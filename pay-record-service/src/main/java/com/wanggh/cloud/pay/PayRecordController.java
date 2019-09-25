package com.wanggh.cloud.pay;

import com.wanggh.cloud.pay.feign.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author wanggh
 */
@RestController
@RequestMapping(value = "/pay/records")
public class PayRecordController {

    @Autowired
    private PayRecordService payRecordService;

    // @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;

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

    @GetMapping("/users/ports")
    public Integer userPort1() {
        return userService.port();
    }
}