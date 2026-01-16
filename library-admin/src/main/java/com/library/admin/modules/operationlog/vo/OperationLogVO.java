package com.library.admin.modules.operationlog.vo;
import java.time.LocalDateTime;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 
/**
 * 操作日誌資料表(OperationLog)VO类
 *
 * @author makejava
 * @since 2026-01-17 00:55:56
 */
@Data
public class OperationLogVO implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = -36184399804107145L;
    
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
