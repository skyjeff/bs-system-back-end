package com.bssystem.commons.exception;

import com.bssystem.commons.result.ResultVo;
import lombok.Data;

/**
 * @Description: 自定义异常
 */
@Data
public class GlobalException extends RuntimeException {

    private ResultVo resultVo;

    public GlobalException() {
    }

    public GlobalException(ResultVo resultVo) {
        this.resultVo = resultVo;
    }
}
