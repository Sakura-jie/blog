package com.cherriesovo.blog.service;

import com.cherriesovo.blog.vo.Result;
import com.cherriesovo.blog.vo.params.CommentParam;

public interface CommentsService {

    //根据文章id查询所有的评论列表
    Result commentsByArticleId(Long articleId);

    Result comment(CommentParam commentParam);
}
