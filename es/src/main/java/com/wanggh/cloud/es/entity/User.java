package com.wanggh.cloud.es.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDateTime;

@Data
@Document(indexName = "user-index", type = "user", shards = 1, replicas = 0, refreshInterval = "-1")
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private String phone;
    private Integer balance;
    private LocalDateTime createAt;
}
