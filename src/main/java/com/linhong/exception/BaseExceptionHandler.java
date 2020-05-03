package com.linhong.exception;

import com.linhong.common.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : jiangzh
 * @program : com.mooc.meetingfilm.utils.exception
 * @description : 公共异常处理
 **/
@Slf4j
@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(CommonServiceException.class)
    @ResponseBody
    public CommonResult serviceExceptionHandler(
            HttpServletRequest request, CommonServiceException e){

        log.error("CommonServiceException, code:{}, message",
                e.getCode(),e.getMessage());

        return CommonResult.serviceException(e);
    }

}
