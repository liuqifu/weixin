package com.forlin.weixin.interceptor;


import com.forlin.weixin.common.ApiResult;
import com.forlin.weixin.common.ResultCodeEnum;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by WenbinChen on 2015/9/10 10:59.
 */
@Controller
@ControllerAdvice
public class ExceptionManager {

    private static final Log log = LogFactory.getLog(ExceptionManager.class);

    /**
     * 所有异常统一处理
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ApiResult runtimeExceptionHandler(Exception ex) {
        log.error(ex);
        log.info("exception:" + ex.getMessage());
        return ApiResult.resultWith(ResultCodeEnum.SYSTEM_BAD_REQUEST, ex.getMessage(), null);
    }
}