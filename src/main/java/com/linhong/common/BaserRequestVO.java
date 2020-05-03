package com.linhong.common;


import com.linhong.exception.CommonServiceException;

/**
 * @author : jiangzh
 * @program : com.mooc.meetingfilm.utils.common.vo
 * @description : 公共的请求对象
 **/
public abstract class BaserRequestVO {

    /**
    * @Description: 公共的参数验证方法
    * @Param: []
    * @return: void
    * @Author: jiangzh
    */
    public abstract void checkParam() throws CommonServiceException;

}
