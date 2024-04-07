package com.cherriesovo.blog.controller;

import com.cherriesovo.blog.dao.pojo.SysUser;
import com.cherriesovo.blog.utils.UserThreadLocal;
import com.cherriesovo.blog.vo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping
    public Result test(){
        SysUser sysUser = UserThreadLocal.get();
        System.out.println(sysUser);
        return Result.success(null);
    }
}