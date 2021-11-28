package inori.blog.transfer.systemtype;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Inori
 */
@Data
public class SystemTypeUpdateInVo {

    /**
     * ID
     */
    @NotNull(message = "参数id缺失")
    private Integer id;


    /**
     * 分类名称
     */
    @NotBlank(message = "参数typeName缺失")
    private String typeName;


}
