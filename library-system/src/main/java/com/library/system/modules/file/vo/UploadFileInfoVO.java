package com.library.system.modules.file.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadFileInfoVO implements Serializable {
    @Serial
    private static final long serialVersionUID = -742158278056987071L;

    /**
     * 檔案名稱
     */
    private String filename;

    /**
     * 檔案網址
     */
    private String url;
}
