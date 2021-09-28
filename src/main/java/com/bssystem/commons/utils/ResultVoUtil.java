package com.bssystem.commons.utils;

import com.bssystem.commons.result.ResultVo;

/**
 * @Description:
 * @Author: Shawn Van
 * @CreateDate: 2019/04/13 下午 05:13
 */
public class ResultVoUtil {
    public static ResultVo success(String message, Object data) {
        return new ResultVo(true, 200, message, data);
    }

    public static ResultVo success(Integer code, String message, Object data) {
        return new ResultVo(true, code, message, data);
    }

    public static ResultVo error(String message) {
        return new ResultVo(false, 400, message);
    }

    public static ResultVo error(Integer code, String message) {
        return new ResultVo(false, code, message);
    }
}
