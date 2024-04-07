package com.cherriesovo.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cherriesovo.blog.dao.dos.Archives;
import com.cherriesovo.blog.dao.pojo.Article;
import com.cherriesovo.blog.vo.Result;
import com.cherriesovo.blog.vo.params.PageParams;

import java.util.List;

//BaseMapper<Article>是mybatisplus提供的，可以很方便的查询Article这张表
/*1、通常情况下，BaseMapper 可能包含一些通用的数据库操作方法的定义，
    比如插入数据、更新数据、删除数据、查询数据等。
    而 ArticleMapper 则可以在此基础上添加针对 Article 实体类的特定数据库操作方法，如根据标题查询文章、根据作者查询文章等。
2、通过这样的设计，可以实现代码的复用，避免重复编写相似的数据库操作方法。
    在具体的实现中，可以在 ArticleMapper 接口中编写与 Article 实体类相关的数据库操作方法，并在其中调用 BaseMapper 中定义的通用方法来实现具体的业务逻辑。
 */
public interface ArticleMapper extends BaseMapper<Article> {
    List<Archives> listArchives();

    IPage<Article> listArticle(Page<Article> page,
                               Long categoryId,
                               Long tagId,
                               String year,
                               String month);
}
