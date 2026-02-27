package com.library.common.constant;

import java.io.Serial;
import java.io.Serializable;

public class CacheTimeConstant implements Serializable {
    @Serial
    private static final long serialVersionUID = 9030730160407626660L;

    /**
     * 驗證碼有效期5min
     */
    public static final Long verifyCodeTime = 5L;
}
