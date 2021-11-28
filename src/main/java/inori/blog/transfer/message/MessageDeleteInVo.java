package inori.blog.transfer.message;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Lnori
 */
@Data
public class MessageDeleteInVo {

    /**
     * ID
     */
    @NotNull(message = "参数id缺失")
    private Integer id;


}
