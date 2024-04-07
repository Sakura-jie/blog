package com.cherriesovo.blog.service;

        import com.cherriesovo.blog.vo.Result;
        import com.cherriesovo.blog.vo.TagVo;

        import java.util.List;

public interface TagService {
    List<TagVo> findTagsByArticleId(Long articleId);
    List<TagVo> hot(int limit);     //最热标签

    Result findAll();   //查询所有的文章标签

    Result findAllDetail();//查询所有的标签

    Result findDetailById(Long id);
}
