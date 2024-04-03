package com.ithuahua.swaggerdemo.controller;

import com.ithuahua.swaggerdemo.pojo.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//Operation 接口
@RestController
public class HelloController {
    @ApiOperation("Hello控制类")
    @GetMapping (value = "/Hello")
    public String hello(){
        return "Hello~";
    }
//    只要我们的返回值接口中存在实体类
    @PostMapping(value = "/User")
    public User user(){
        return new User();
    }
}
