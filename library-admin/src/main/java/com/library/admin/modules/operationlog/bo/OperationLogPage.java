package com.library.admin.modules.operationlog.bo;
 
import java.time.LocalDateTime;
import lombok.Data;
import com.library.common.constant.BasePage;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 
/**
 * 操作日誌資料表(OperationLog)BO类
 *
 * @author makejava
 * @since 2026-01-17 00:55:57
 */
@Data
public class OperationLogPage extends BasePage implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 363382179916354619L;
    
/**
     * 主鍵
     */ 
    private Integer id;
/**
     * IP地址
     */ 
    private String requestIp;
/**
     * IP來源
     */ 
    private String address;
/**
     * 請求方法
     */ 
    private String methods;
/**
     * 請求參數
     */ 
    private String params;
/**
     * 操作人
     */ 
    private String username;
/**
     * 傳回參數
     */ 
    private String returnValue;
/**
     * 日誌類型: 預設為0 0:操作日誌; 1:登入日誌; 2:退出
     */ 
    private Integer logType;
/**
     * 描述
     */ 
    private String description;
/**
     * 瀏覽器
     */ 
    private String browser;
/**
     * 建立時間
     */ 
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
 
}
