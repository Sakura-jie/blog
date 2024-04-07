package com.cherriesovo.blog.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cherriesovo.blog.dao.mapper.ArticleMapper;
import com.cherriesovo.blog.dao.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ThreadService {

    //期望此操作在线程池中执行，不会影响原有的主线程
    @Async("taskExecutor")
    public void updateArticleViewCount(ArticleMapper articleMapper, Article article){

        int viewCounts = article.getViewCounts();
        Article articleUpdate = new Article();
        articleUpdate.setViewCounts(viewCounts + 1);
        LambdaQueryWrapper<Article> updateWrapper = new LambdaQueryWrapper<>();
        updateWrapper.eq(Article::getId,article.getId());
        //设置一个 为了在多线程环境下 线程安全
        updateWrapper.eq(Article::getViewCounts,article.getViewCounts());
//update article set view_count=100 where view_count=99 and id=11
        articleMapper.update(articleUpdate,updateWrapper);
//        try {
//            //睡眠5秒 证明不会影响主线程的使用，5秒后数据才会出现
//            Thread.sleep(5000);
////            System.out.println("更新完成了");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
