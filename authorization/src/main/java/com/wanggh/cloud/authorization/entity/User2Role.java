package com.wanggh.cloud.authorization.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_2_role")
public class User2Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long roleId;
}
