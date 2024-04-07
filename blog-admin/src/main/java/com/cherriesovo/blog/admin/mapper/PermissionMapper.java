package com.cherriesovo.blog.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cherriesovo.blog.admin.pojo.Permission;

import java.util.List;

public interface PermissionMapper extends BaseMapper<Permission> {

    List<Permission> findPermissionsByAdminId(Long adminId);
}