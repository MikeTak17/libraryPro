package com.library.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {
    SUCCESS(200,"成功"),
    FAIL(500, "失敗"),
    FILE_NONE(0001, "空檔案");

    private int code;
    private String desc;
}