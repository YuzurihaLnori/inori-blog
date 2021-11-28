package inori.blog.transfer.systemblog;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Inori
 */
@Data
public class SystemBlogRecommendInVo {

    /**
     * ID
     */
    @NotNull(message = "参数id缺失")
    private Integer id;


    /**
     * 推荐
     */
    @NotNull(message = "参数recommend缺失")
    private Integer recommend;


}
