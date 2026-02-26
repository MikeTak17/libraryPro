package com.library.system.modules.emailconfig.bo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.library.common.constant.BasePage;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 郵件配置(EmailConfig)BO类
 *
 * @author makejava
 * @since 2026-02-26 19:18:26
 */
@Data
public class EmailConfigPage extends BasePage implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 858900422794044935L;

    /**
     * 主鍵ID
     */
    private Integer id;
    /**
     * 發送電子郵件帳號
     */
    private String fromUser;
    /**
     * 建立者
     */
    private String username;
    /**
     * 郵件伺服器SMTP位置
     */
    private String host;
    /**
     * 密碼
     */
    private String pass;
    /**
     * 通訊port
     */
    private String port;
    /**
     * 配置狀態（0正常 1停用）
     */
    private Integer emailStatus;
    /**
     * 備註
     */
    private String remark;
    /**
     * 建立時間
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
