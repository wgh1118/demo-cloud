package com.wanggh.cloud.nacos.order.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class OrderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Integer price;

    private Integer quantity;

    @CreatedDate
    private LocalDateTime createAt;

    @CreatedBy
    private Long createBy;

    @LastModifiedDate
    private LocalDateTime updateAt;

    @LastModifiedBy
    private Long updateBy;
}
