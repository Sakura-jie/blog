package com.cherriesovo.blog.admin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Permission {

    @TableId(type = IdType.AUTO)    //自增 id
    private Long id;

    private String name;

    private String path;    //权限请求路径

    private String description;
}
