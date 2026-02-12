package com.library.admin.modules.user.bo;
 
import java.time.LocalDateTime;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 
/**
 * 使用者資料表(User)BO类
 *
 * @author makejava
 * @since 2026-02-12 17:44:22
 */
@Data
public class UserInsert implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 600852601197535592L;
    
/**
     * 使用者ID
     */ 
    private Integer id;
/**
     * 使用者姓名
     */ 
    private String realName;
/**
     * 使用者帳號
     */ 
    private String userName;
/**
     * 使用者密碼
     */ 
    private String password;
/**
     * 使用者EMAIL
     */ 
    private String email;
/**
     * 手機號碼
     */ 
    private Long phone;
/**
     * 使用者性別(0: 男; 1: 女; 2:未知)
     */ 
    private Integer sex;
/**
     * 圖示
     */ 
    private String avatar;
/**
     * 帳號狀態(0: 正常; 1: 停用)
     */ 
    private Integer status;
/**
     * 使用者角色
     */ 
    private String roleIds;
/**
     * 最後登入時間
     */ 
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime loginDate;
/**
     * 建立時間
     */ 
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
/**
     * 修改時間
     */ 
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
/**
     * 最後修改密碼日期
     */ 
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastPasswordResetTime;
/**
     * 使用者備註
     */ 
    private String remark;
/**
     * 使用者編號
     */ 
    private String jobNumber;
/**
     * 餘額
     */ 
    private Double balance;
/**
     * 個人簡介
     */ 
    private String introduction;
/**
     * 所在地區
     */ 
    private String address;
 
}
