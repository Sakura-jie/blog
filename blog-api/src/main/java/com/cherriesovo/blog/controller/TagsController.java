package com.cherriesovo.blog.controller;

import com.cherriesovo.blog.service.TagService;
import com.cherriesovo.blog.vo.Result;
import com.cherriesovo.blog.vo.TagVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tags")
public class TagsController {

    @Autowired
    private TagService tagsService;

    //路径：/tags/hot
    @GetMapping("/hot")
    public Result listHotTags() {
        int limit = 6;  //查询最热的6个标签
        List<TagVo> tagVoList = tagsService.hot(limit);
        return Result.success(tagVoList);
    }

    @GetMapping
    public Result findAll(){
        return tagsService.findAll();
    }

    @GetMapping("detail")
    public Result findAllDetail(){
        return tagsService.findAllDetail();
    }

    //标签文章列表
    @GetMapping("detail/{id}")
    public Result findDetailById(@PathVariable("id") Long id){
        return tagsService.findDetailById(id);
    }
}