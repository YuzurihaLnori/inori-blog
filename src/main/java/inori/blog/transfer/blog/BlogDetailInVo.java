package inori.blog.transfer.blog;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Lnori
 */
@Data
public class BlogDetailInVo {

    /**
     * 博客ID
     */
    @NotNull(message = "参数blogId缺失")
    private Integer blogId;


}
