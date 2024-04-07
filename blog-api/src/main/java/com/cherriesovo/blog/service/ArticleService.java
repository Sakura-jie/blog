package com.cherriesovo.blog.service;

//import com.cherriesovo.blog.vo.Archive;
import com.cherriesovo.blog.vo.ArticleVo;
import com.cherriesovo.blog.vo.Result;
import com.cherriesovo.blog.vo.params.ArticleParam;
import com.cherriesovo.blog.vo.params.PageParams;

import java.util.List;

public interface ArticleService {
    //分页查询文章列表
    List<ArticleVo> listArticlesPage(PageParams pageParams);

    //首页最热文章
    Result hotArticle(int limit);

    //最新文章
    Result newArticles(int limit);

    //文章归档
    Result listArchives();

    //查看文章详情
    Result findArticleById(Long articleId);

    //文章发布
    Result publish(ArticleParam articleParam);
}
