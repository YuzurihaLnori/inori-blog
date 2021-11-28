package inori.blog.transfer.systemtype;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Inori
 */
@Data
public class SystemTypeDeleteInVo {

    /**
     * ID
     */
    @NotNull(message = "参数id缺失")
    private Integer id;


}
