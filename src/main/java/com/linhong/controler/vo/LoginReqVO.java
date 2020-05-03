package com.linhong.controler.vo;

import com.linhong.common.BaserRequestVO;
import com.linhong.exception.CommonServiceException;
import lombok.Data;
import org.springframework.util.StringUtils;

@Data
public class LoginReqVO extends BaserRequestVO {

    private String username;
    private String password;

    @Override
    public void checkParam()  throws CommonServiceException {
        // TODO 验证数据合法性
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            throw new CommonServiceException(404,"username 或 password不能为空");
        }

    }

}