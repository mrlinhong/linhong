package com.linhong.controler;

import com.google.common.collect.Lists;
import com.linhong.common.CommonResult;
import com.linhong.controler.vo.LoginReqVO;
import com.linhong.exception.CommonServiceException;
import com.linhong.mbg.model.PmsBrand;
import com.linhong.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private PmsBrandService demoService;

    @GetMapping("/hello")
    public String hello(){

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
        return "hello linhong, 当前时间是：" + format.format(new Date());
    }

    @GetMapping("/checkUser")
    public CommonResult checkUser(@RequestBody LoginReqVO reqVO) throws CommonServiceException {

        // 数据验证
        reqVO.checkParam();

        return CommonResult.success(null);


    }


}
