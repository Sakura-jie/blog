package com.cherriesovo.blog.service;

import com.cherriesovo.blog.dao.pojo.SysUser;
import com.cherriesovo.blog.vo.Result;
import com.cherriesovo.blog.vo.params.LoginParam;
import org.springframework.transaction.annotation.Transactional;

public interface LoginService {
    //登录功能
    Result login(LoginParam loginParam);

    SysUser checkToken(String token);

    //退出登录
    Result logout(String token);

    //注册
    Result register(LoginParam loginParam);
}
