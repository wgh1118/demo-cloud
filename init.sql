CREATE TABLE `user`
(
    `id`        bigint(20) NOT NULL AUTO_INCREMENT,
    `username`  varchar(32) DEFAULT NULL,
    `create_at` datetime    DEFAULT NULL,
    `update_at` datetime    DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `pay_record`
(
    `id`        bigint(20) NOT NULL AUTO_INCREMENT,
    `user_id`   bigint(20)   DEFAULT NULL,
    `code`      varchar(255) DEFAULT NULL,
    `create_at` datetime     DEFAULT NULL,
    `update_at` datetime     DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;