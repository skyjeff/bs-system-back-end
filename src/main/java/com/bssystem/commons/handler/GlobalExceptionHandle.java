package com.bssystem.commons.handler;

import com.bssystem.commons.exception.GlobalException;
import com.bssystem.commons.result.ResultVo;
import com.bssystem.commons.utils.ResultVoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description: 全局捕获处理异常
 * @Author: Shawn Van
 * @CreateDate: 2019/04/13 下午 05:33
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandle {
    //用户操作异常，所以用warn等级日志
    @ExceptionHandler(value = GlobalException.class)
    public ResultVo resultExceptionHandler(GlobalException e) {
        log.warn("【异常捕获】GlobalException={}", e.getResultVo().getMessage());
        return ResultVoUtil.error(e.getResultVo().getCode(), e.getResultVo().getMessage());
    }

    //系统出现异常，用error等级日志
    @ExceptionHandler(value = Exception.class)
    public ResultVo resultExceptionHandler(Exception e) {
        log.error("【异常捕获】Exception={}", e.getMessage());
        log.error("【异常捕获】{}", e);
        e.printStackTrace();
        return ResultVoUtil.error(e.getMessage());
    }
}
