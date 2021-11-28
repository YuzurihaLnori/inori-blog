package inori.blog.transfer.blog;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Lnori
 */
@Data
public class BlogRecommendOutVo {

    /**
     * 浏览次数
     */
    @NotNull(message = "参数views缺失")
    private Integer views;


    /**
     * 博客推荐上
     */
    @NotNull(message = "参数blogId缺失")
    private BlogRecommendOutVoPrevious previous;


    /**
     * 博客推荐下
     */
    @NotNull(message = "参数blogId缺失")
    private BlogRecommendOutVoNext next;


}
