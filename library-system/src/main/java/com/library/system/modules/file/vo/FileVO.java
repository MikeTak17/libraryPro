package com.library.system.modules.file.vo;

import java.time.LocalDateTime;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

/**
 * 使用者資料表(File)VO类
 *
 * @author makejava
 * @since 2026-02-12 20:01:40
 */
@Data
public class FileVO implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = -37476668828309336L;

    /**
     * 主鍵id
     */
    private Integer id;
    /**
     * 使用者帳號
     */
    private String username;
    /**
     * 原始檔案名稱
     */
    private String originalFilename;
    /**
     * 檔案大小
     */
    private Long fileSize;
    /**
     * 檔案網址
     */
    private String url;
    /**
     * 儲存平台
     */
    private String storagePlatform;
    /**
     * 基本儲存路徑
     */
    private String basePath;
    /**
     * 儲存路徑
     */
    private String storagePath;
    /**
     * 儲存檔案名稱
     */
    private String storageFilename;
    /**
     * 檔案副檔名
     */
    private String ext;
    /**
     * 檔案所屬物件類型
     */
    private Integer objectType;
    /**
     * 檔案標籤，唯一
     */
    private String fileSign;
    /**
     * 邏輯刪除標示 1:刪除
     */
    private Byte delFlag;
    /**
     * 建立時間
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
