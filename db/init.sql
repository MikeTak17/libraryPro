CREATE TABLE `lib_operation_log`
(
    `id`           INT          NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
    `request_ip`   VARCHAR(128)          DEFAULT NULL COMMENT 'ip地址',
    `address`      VARCHAR(255) NULL     DEFAULT '' COMMENT 'ip来源',
    `methods`      TEXT         NULL COMMENT '请求方法',
    `params`       TEXT         NULL COMMENT '请求参数',
    `username`     VARCHAR(50)  NOT NULL DEFAULT '' COMMENT '操作人',
    `return_value` TEXT         NULL COMMENT '返回参数',
    `log_type`     INT          NOT NULL DEFAULT 0 COMMENT '日志类型：默认为0，0:操作日志，1:登录日志, 2:登出',
    `description`  VARCHAR(255)          DEFAULT NULL COMMENT '描述',
    `browser`      VARCHAR(255)          DEFAULT NULL COMMENT '浏览器',
    `create_time`  DATETIME     NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    KEY `log_create_time_index` (`create_time`)
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic
    COMMENT ='操作日志表';
