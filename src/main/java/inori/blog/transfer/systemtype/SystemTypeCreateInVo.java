package inori.blog.transfer.systemtype;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Inori
 */
@Data
public class SystemTypeCreateInVo {

    /**
     * 分类名称
     */
    @NotBlank(message = "参数typeName缺失")
    private String typeName;


}
