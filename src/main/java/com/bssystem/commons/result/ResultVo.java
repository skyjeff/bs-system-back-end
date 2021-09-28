package com.bssystem.commons.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description:
 * @Author: Shawn Van
 * @CreateDate: 2019/04/13 下午 04:45
 */
@Data
public class ResultVo<T> {
    @ApiModelProperty("状态")
    private Boolean status;
    @ApiModelProperty("提示码")
    private Integer code;
    @ApiModelProperty("提示信息")
    private String message;
    @ApiModelProperty("操作返回的具体数据")
    private T data;

    public ResultVo() {
    }

    public ResultVo(Boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResultVo(Boolean status, Integer code) {
        this.status = status;
        this.code = code;
    }

    public ResultVo(Boolean status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResultVo(Boolean status, Integer code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public ResultVo(Boolean status, Integer code, String message, T data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
