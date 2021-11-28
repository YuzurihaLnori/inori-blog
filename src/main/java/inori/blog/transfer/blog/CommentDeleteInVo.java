package inori.blog.transfer.blog;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Lnori
 */
@Data
public class CommentDeleteInVo {

    /**
     * ID
     */
    @NotNull(message = "参数id缺失")
    private Integer id;


}
