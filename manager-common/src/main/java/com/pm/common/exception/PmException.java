package com.pm.common.exception;

import com.pm.common.enums.ExceptionEnum;
import lombok.Getter;

/**
 * @Description: 类（或接口）是 自定义异常类
 * @ClassName: PmException
 * @Author: xwt
 * @version: 1.0
 */
@Getter
public class PmException extends RuntimeException {
    private int status;
    private String msg;

    public PmException(ExceptionEnum em) {
        super(em.getMsg());
        this.msg = em.getMsg();
        this.status = em.getStatus();
    }

    public PmException(ExceptionEnum em, Throwable cause) {
        super(em.getMsg(), cause);
        this.status = em.getStatus();
    }
}
