package com.cherriesovo.blog.admin.vo;

import lombok.Data;

import java.util.List;

//分页的结果类
@Data
public class PageResult<T> {

    private List<T> list;

    private Long total;
}