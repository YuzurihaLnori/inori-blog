package inori.blog.dao;

import com.baomidou.mybatisplus.plugins.Page;
import inori.blog.transfer.blog.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Lnori
 */
public interface BlogMapper {


    /**
     * 博客详情
     *
     * @param inVo 条件
     * @return 详情
     */
    BlogDetailOutVo blogDetail(BlogDetailInVo inVo);


    /**
     * 增加浏览次数
     *
     * @param blogId 博客ID
     */
    void blogViews(Integer blogId);


    /**
     * 博客推荐
     *
     * @param inVo 条件
     * @return 列表
     */
    BlogRecommendOutVo blogRecommend(BlogRecommendInVo inVo);

    /**
     * 评论列表
     *
     * @param page 分页
     * @param inVo 条件
     * @return 列表
     */
    List<CommentListOutVoRecords> commentList(@Param("page") Page<CommentListOutVoRecords> page, @Param("inVo") CommentListInVo inVo);


    /**
     * 评论总条数
     *
     * @param blogId 博客ID
     * @return 总条数
     */
    Integer getTotalNumber(Integer blogId);


    /**
     * 录入评论
     *
     * @param inVo 条件
     */
    void commentCreate(CommentCreateInVo inVo);


    /**
     * 删除评论
     *
     * @param inVo 条件
     */
    void commentDelete(CommentDeleteInVo inVo);


}
