package com.linhong.controler;

import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
        return "hello linhong, 当前时间是：" + format.format(new Date());
    }
}
