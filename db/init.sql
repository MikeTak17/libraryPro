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

DROP TABLE IF EXISTS `lib_user`;
CREATE TABLE `lib_user`(
    `id`            INT(11) NOT NULL AUTO_INCREMENT COMMENT '使用者ID',
    `real_name`     VARCHAR(100) NOT NULL COMMENT '使用者姓名',
    `user_name`     VARCHAR(100) NOT NULL COMMENT '使用者帳號',
    `password`      VARCHAR(100) NOT NULL COMMENT '使用者密碼',
    `email`         VARCHAR(100) DEFAULT '' COMMENT '使用者EMAIL',
    `phone`         BIGINT(11) NOT NULL COMMENT '手機號碼',
    `sex`           INT NOT NULL DEFAULT 0 COMMENT '使用者性別(0: 男; 1: 女; 2:未知)',
    `avatar`        VARCHAR(500) DEFAULT  '' COMMENT '圖示',
    `status`        INT DEFAULT 0 COMMENT '帳號狀態(0: 正常; 1: 停用)',
    `role_ids`      VARCHAR(255) NOT NULL COMMENT '使用者角色',
    `login_date`    DATETIME DEFAULT NULL COMMENT '最後登入時間',
    `create_time`   DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建立時間',
    `update_time`   DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改時間',
    `last_password_reset_time`  DATETIME DEFAULT NULL  COMMENT '最後修改密碼日期',
    `remark`        VARCHAR(500) DEFAULT NULL COMMENT '使用者備註',
    `job_number`    VARCHAR(50) NOT NULL COMMENT '使用者編號',
    `balance`       DECIMAL(10, 2) NOT NULL DEFAULT 0.00 COMMENT '餘額',
    `introduction`  TEXT NULL COMMENT '個人簡介',
    `address`       VARCHAR(500) DEFAULT NULL COMMENT '所在地區',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic
  COMMENT = '使用者資料表';

DROP TABLE IF EXISTS `lib_file`;
CREATE TABLE `lib_file`(
    `id`            INT(11) NOT NULL AUTO_INCREMENT COMMENT '主鍵id',
    `username`      VARCHAR(50) DEFAULT NULL COMMENT '使用者帳號',
    `original_filename`     VARCHAR(100) NOT NULL COMMENT '原始檔案名稱',
    `file_size`     BIGINT(20)  DEFAULT NULL COMMENT '檔案大小',
    `url`           VARCHAR(255) DEFAULT NULL   COMMENT '檔案網址',
    `storage_platform`  VARCHAR(50) NOT NULL COMMENT '儲存平台',
    `base_path`     VARCHAR(256)    DEFAULT NULL COMMENT '基本儲存路徑',
    `storage_path`  VARCHAR(512) DEFAULT NULL COMMENT '儲存路徑',
    `storage_filename`  VARCHAR(255) DEFAULT NULL COMMENT '儲存檔案名稱',
    `ext`  VARCHAR(32) DEFAULT NULL COMMENT '檔案副檔名',
    `object_type`   INT NOT NULL DEFAULT 0 COMMENT '檔案所屬物件類型',
    `file_sign`     VARCHAR(32) DEFAULT NULL COMMENT '檔案標籤，唯一',
    `del_flag`      TINYINT NOT NULL DEFAULT 0 COMMENT '邏輯刪除標示 1:刪除',
    `create_time`   DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建立時間',
    PRIMARY KEY(`id`) USING BTREE
)  ENGINE = InnoDB
   CHARACTER SET = utf8mb4
   COLLATE = utf8mb4_general_ci
   ROW_FORMAT = Dynamic
   COMMENT = '使用者資料表';

DROP TABLE IF EXISTS `lib_email_config`;
CREATE TABLE `lib_email_config`
(
    `id`           INT(11)  NOT NULL AUTO_INCREMENT COMMENT '主鍵ID',
    `from_user`    VARCHAR(255)      DEFAULT NULL COMMENT '發送電子郵件帳號',
    `username`     VARCHAR(50)       DEFAULT NULL COMMENT '建立者',
    `host`         VARCHAR(50)       DEFAULT NULL COMMENT '郵件伺服器SMTP位置',
    `pass`         VARCHAR(255)      DEFAULT NULL COMMENT '密碼',
    `port`         VARCHAR(50)       DEFAULT NULL COMMENT '通訊port',
    `email_status` INT      NOT NULL COMMENT '配置狀態（0正常 1停用）',
    `remark`       VARCHAR(255)      DEFAULT NULL COMMENT '備註',
    `create_time`  DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建立時間',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic
    COMMENT ='郵件配置';
