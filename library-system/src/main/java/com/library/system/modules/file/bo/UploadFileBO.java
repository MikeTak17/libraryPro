package com.library.system.modules.file.bo;

import lombok.Data;

/**
 * 上傳檔案
 *
 *
 *
 **/
@Data
public class UploadFileBO {

    /**
     * 檔案所屬物件類型, 如使用者圖示
     *
     */
    private Integer objectType;

    /**
     * 使用者帳號
     */
    private String username;

    /**
     * 檔案標示, 唯一
     */
    private String fileSign;

}
