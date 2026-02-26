package com.library.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: xyh
 * @create: 2023-09-24
 **/
@Getter
@AllArgsConstructor
public enum StatusEnum {

    NORMAL(0, "正常"),
    STOP(1, "停用"); //停用或冻结

    private Integer code;
    private String desc;


    public static String getValue(Integer code) {
        StatusEnum[] statusEnums = values();
        for (StatusEnum statusEnum : statusEnums) {
            if (statusEnum.getCode().equals(code)) {
                return statusEnum.getDesc();
            }
        }
        return null;
    }

}
