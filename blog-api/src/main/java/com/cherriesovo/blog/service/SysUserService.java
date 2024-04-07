package com.cherriesovo.blog.service;

import com.cherriesovo.blog.dao.pojo.SysUser;
import com.cherriesovo.blog.vo.Result;
import com.cherriesovo.blog.vo.UserVo;

public interface SysUserService {
    SysUser findUserById(Long id);

    SysUser findUser(String account, String pwd);

    //根据token查询用户信息
    Result findUserByToken(String token);

    //根据账户查询用户
    SysUser findUserByAccount(String account);

    //保存用户
    void save(SysUser sysUser);

    UserVo findUserVoById(Long authorId);
}
