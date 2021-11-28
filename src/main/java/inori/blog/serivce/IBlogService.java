package inori.blog.serivce;

import inori.blog.transfer.blog.*;

/**
 * @author Lnori
 */
public interface IBlogService {

    /**
     * 生成博客
     *
     * @param inVo 条件
     */
    void blogDetail(BlogDetailInVo inVo);

    /**
     * 博客推荐
     *
     * @param inVo 条件
     * @return 推荐
     */
    BlogRecommendOutVo blogRecommend(BlogRecommendInVo inVo);

    /**
     * 评论列表
     *
     * @param inVo 条件
     * @return 列表
     */
    CommentListOutVo commentList(CommentListInVo inVo);

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
