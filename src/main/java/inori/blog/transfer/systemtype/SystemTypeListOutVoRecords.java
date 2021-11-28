package inori.blog.transfer.systemtype;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Inori
 */
@Data
public class SystemTypeListOutVoRecords {

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


    /**
     * 更新时间
     */
    @NotBlank(message = "参数updateTime缺失")
    private String updateTime;


}
