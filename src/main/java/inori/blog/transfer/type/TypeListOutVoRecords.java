package inori.blog.transfer.type;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Inori
 */
@Data
public class TypeListOutVoRecords {

    /**
     * ID
     */
    @NotNull(message = "参数id缺失")
    private Integer id;


    /**
     * 分类名称
     */
    @NotBlank(message = "参数name缺失")
    private String name;


}
