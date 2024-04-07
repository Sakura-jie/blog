package com.cherriesovo.blog.controller;

import com.cherriesovo.blog.common.aop.LogAnnotation;
import com.cherriesovo.blog.common.cache.Cache;
import com.cherriesovo.blog.service.ArticleService;
import com.cherriesovo.blog.vo.ArticleVo;
import com.cherriesovo.blog.vo.params.ArticleParam;
import com.cherriesovo.blog.vo.params.PageParams;
import com.cherriesovo.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//json数据进行交互
@RestController
@RequestMapping("articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    //Result是统一结果返回

    /*
    *首页文章列表
    * */
    @PostMapping
    //加上此注解，代表要对此接口记录日志
    @LogAnnotation(module="文章",operator="获取文章列表")
    @Cache(expire = 5 * 60 * 1000,name = "list_article")
    public Result articles(@RequestBody PageParams pageParams) {
        //ArticleVo 页面接收的数据
        List<ArticleVo> articles = articleService.listArticlesPage(pageParams);

        return Result.success(articles);
    }

    /*
    * 首页最热文章
    * */
    @PostMapping("hot")
    @Cache(expire = 5 * 60 * 1000,name = "hot_article")
    public Result hotArticle(){
        int limit = 5;
        return articleService.hotArticle(limit);
    }

    /*
    * 最新文章
    * */
    @PostMapping("new")
    @Cache(expire = 5 * 60 * 1000,name = "news_article")
    public Result newArticles(){
        int limit = 5;
        return articleService.newArticles(limit);
    }

    /*
    * 文章归档
    * */
    @PostMapping("listArchives")
    public Result listArchives(){
        return articleService.listArchives();
    }

    /*
    * 通过id获取文章
    * */
    @PostMapping("view/{id}")
    public Result findArticleById(@PathVariable("id") Long articleId) {

        return articleService.findArticleById(articleId);
    }

    /*
    * 发布文章
    * */
    @PostMapping("publish")
    public Result publish(@RequestBody ArticleParam articleParam){
        return articleService.publish(articleParam);
    }
}
